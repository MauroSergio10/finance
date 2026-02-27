package com.project.transaction_service.application.gateway;

import com.project.transaction_service.domain.model.TransactionModel;

public interface TransactionGateway {
    TransactionModel create(TransactionModel transactionModel);
    TransactionModel update(Long id, TransactionModel transactionModel);
    void delete(Long id);
}