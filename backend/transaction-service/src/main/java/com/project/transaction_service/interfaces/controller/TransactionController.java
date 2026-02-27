package com.project.transaction_service.interfaces.controller;

import com.project.transaction_service.application.usecase.TransactionCreate;
import com.project.transaction_service.domain.dto.transaction.TransactionRequest;
import com.project.transaction_service.domain.dto.transaction.TransactionResponse;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.interfaces.mapper.TransactionDTOMapper;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionDTOMapper transactionMapper;
    private final TransactionCreate transactionCreate;

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
           @Valid @RequestBody TransactionRequest request
    ) {
        TransactionModel model = transactionMapper.toModel(request);

        TransactionModel created = transactionCreate.execute(model);

        TransactionResponse response = transactionMapper.toDto(created);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}