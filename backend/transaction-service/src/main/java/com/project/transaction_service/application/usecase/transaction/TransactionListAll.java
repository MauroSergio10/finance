package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionListAll {

    private final TransactionGateway transactionGateway;

    public List<TransactionModel> execute() {
        return transactionGateway.listAll();
    }
}

