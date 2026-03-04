package com.project.transaction_service.interfaces.controller;

import com.project.transaction_service.application.usecase.transaction.TransactionCreate;
import com.project.transaction_service.application.usecase.transaction.TransactionUpdate;
import com.project.transaction_service.application.usecase.transaction.TransactionDelete;
import com.project.transaction_service.application.usecase.transaction.TransactionListAll;
import com.project.transaction_service.domain.dto.transaction.TransactionRequest;
import com.project.transaction_service.domain.dto.transaction.TransactionResponse;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.interfaces.mapper.TransactionDTOMapper;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionDTOMapper transactionMapper;
    private final TransactionCreate transactionCreate;
    private final TransactionUpdate transactionUpdate;
    private final TransactionDelete transactionDelete;
    private final TransactionListAll transactionListAll;

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

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponse> updateTransaction(
            @PathVariable Long id,
            @Valid @RequestBody TransactionRequest request
    ) {
        TransactionModel model = transactionMapper.toModel(request);

        TransactionModel updated = transactionUpdate.execute(id, model);

        TransactionResponse response = transactionMapper.toDto(updated);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionDelete.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> listAllTransactions() {
        List<TransactionModel> models = transactionListAll.execute();
        List<TransactionResponse> responses = models.stream()
                .map(transactionMapper::toDto)
                .toList();

        return ResponseEntity.ok(responses);
    }
}