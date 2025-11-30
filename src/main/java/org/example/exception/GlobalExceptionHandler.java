package org.example.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.cglib.core.Local;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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
            String message
    ) {}

    //Validação do @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName =  ((FieldError) error).getField();
            String erroMessage = error.getDefaultMessage();
            errors.put(fieldName, erroMessage);
        });

        return errors;
    }

    //Unique constraints
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorBody handleUnique(DataIntegrityViolationException ex){
        return new ErrorBody(LocalDateTime.now(), "UNIQUE CONSTRAINTS", "Valor duplicado: esse registro já existe");
    }

    //Listen all CustomException and sons
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorBody> handleCustomException(CustomException ex){
        return ResponseEntity
                .status(ERROR_MAP.getOrDefault(ex.getClass(), HttpStatus.INTERNAL_SERVER_ERROR))
                .body(new ErrorBody(LocalDateTime.now(), ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(ErrorResponseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorBody handleServerError(CustomException ex){
       return new ErrorBody(LocalDateTime.now(), "ERRO_INTERNO", "Erro interno no servidor");
    }
}
