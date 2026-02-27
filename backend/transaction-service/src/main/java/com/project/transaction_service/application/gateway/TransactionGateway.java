package com.project.transaction_service.application.gateway;

import com.project.transaction_service.domain.model.TransactionModel;

import java.util.List;

public interface TransactionGateway {
    TransactionModel create(TransactionModel transactionModel);
}