package com.project.transaction_service.application.usecase;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class TransactionCreate {

    private final TransactionGateway transactionRepository;

    public TransactionModel execute(TransactionModel model){

        if(model.amount().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Amount must be greater than zero");



        return transactionRepository.create(model);
    }
}

