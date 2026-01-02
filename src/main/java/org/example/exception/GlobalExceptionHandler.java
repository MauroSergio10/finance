package org.example.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //Listen all Controlls
public class GlobalExceptionHandler {

    private static final Map<Class<?>, HttpStatus> ERROR_MAP = Map.of(
            NotFoundException.class, HttpStatus.NOT_FOUND,
            TimeoutException.class, HttpStatus.BAD_GATEWAY,
            BadRequestException.class, HttpStatus.BAD_REQUEST
    );
    //Static class for organize return data
    public record ErrorBody(
            LocalDateTime timestamp,
            String error,
            Object message
    ) {}

    //Bean validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorBody> handleValidation(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(
                new ErrorBody(
                        LocalDateTime.now(),
                        "INVALID_REQUEST",
                        errors));
    }

    //Database Constraints
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorBody> handleDataIntegrity(DataIntegrityViolationException ex){

        return ResponseEntity.status(409).body(
                new ErrorBody(
                        LocalDateTime.now(),
                        "DATA_INTEGRITY_VIOLATION",
                        ex.getMessage()));
    }

    //Listen all CustomException and sons
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorBody> handleCustomException(CustomException ex){
        return ResponseEntity
                .status(ERROR_MAP.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR))
                .body(
                        new ErrorBody(
                                LocalDateTime.now(),
                                ex.getCode(),
                                ex.getMessage()));
    }

    @ExceptionHandler(ErrorResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorBody handleServerError(CustomException ex){
       return new ErrorBody(
               LocalDateTime.now(),
               "ERRO_INTERNO",
               "Erro interno no servidor");
    }
}
