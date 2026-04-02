package com.project.transaction_service.infrastructure.mapper;

import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.Transaction;

public class TransactionEntityMapper {

    public TransactionModel toModel(Transaction transaction){
        return new TransactionModel(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate(),
                transaction.getCategory() == null
                        ? null
                        : transaction.getCategory().getId(),
                transaction.getCategory() == null
                        ? null
                        : transaction.getCategory().getName(),
                transaction.getBankAccount().getId()
        );
    }
}
