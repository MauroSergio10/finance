package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.Transaction;

public class TransactionEntityMapper {

    public TransactionModel toModel(Transaction transaction){
        return new TransactionModel(
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate()
        );
    }

    public Transaction toEntity(TransactionModel model){
        return new Transaction(
                model.description(),
                model.amount(),
                model.type(),
                model.date()
        );
    }
}
