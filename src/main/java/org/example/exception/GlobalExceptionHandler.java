package org.example.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    )

    //Validação do @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    //Unique constraints
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleUnique(DataIntegrityViolationException ex){
        //409
        Map<String, Object> body = new HashMap<>();
        body.put("Timestamp", LocalDateTime.now());
        body.put("error", "Unique_CONSTRAINTS");
        body.put("message", "Valor duplicado: este registro já existe");

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(CustomException.class)//Listen all CustomException and sons
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex){

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", ex.getCode());
        body.put("message", ex.getMessage());

        //Decide qual status HTTP retornar
        return ResponseEntity.status(status).body(body);
    }

}
