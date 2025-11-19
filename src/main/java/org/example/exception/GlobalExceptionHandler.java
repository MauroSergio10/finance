package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //Listen all Controlls
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)//Listen all CustomException and sons
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex){

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", ex.getCode());
        body.put("message", ex.getMessage());

        //Decide qual status HTTP retornar
        HttpStatus status;

        if(ex instanceof NotFoundException){
            status = HttpStatus.NOT_FOUND; // 404
        }else{
            status = HttpStatus.BAD_REQUEST; // 500
        }

        return ResponseEntity.status(status).body(body);
    }

}
