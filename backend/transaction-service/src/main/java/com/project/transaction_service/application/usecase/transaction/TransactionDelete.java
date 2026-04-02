package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.TransactionGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionDelete {

    private final TransactionGateway transactionGateway;

    public void execute(Long id) {
        transactionGateway.delete(id);
    }
}

