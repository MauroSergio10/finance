package com.project.transaction_service.infrastructure.mapper;

import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.Category;
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
                        : new com.project.transaction_service.domain.model.CategoryModel(
                                transaction.getCategory().getId(),
                                transaction.getCategory().getName()
                        )
        );
    }

    public Transaction toEntity(TransactionModel transactionModel, Category category){
        return new Transaction(
                transactionModel.description(),
                transactionModel.amount(),
                transactionModel.type(),
                transactionModel.date(),
                category
        );
    }

}
