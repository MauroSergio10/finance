package com.project.transaction_service.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleTransactionValidationExpection(MethodArgumentNotValidException e) {

        List<String> erros = e.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();

        ErrorDetails erroFormart = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                erros);

        return ResponseEntity.badRequest().body(erroFormart);
    }

}
