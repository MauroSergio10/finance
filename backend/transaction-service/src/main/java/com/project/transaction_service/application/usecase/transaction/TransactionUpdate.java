package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class TransactionUpdate {

    private final TransactionGateway transactionGateway;
    private final CategoryGateway categoryGateway;

    public TransactionModel execute(Long id, TransactionModel model) {
        if (model.amount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        TransactionModel validatedModel = attachExistingCategory(model);

        return transactionGateway.update(id, validatedModel);
    }

    private TransactionModel attachExistingCategory(TransactionModel model) {
        if (model.category() == null || model.category().id() == null) {
            // se não informar categoryId no update, mantém a categoria atual (gateway/infra cuida disso)
            return new TransactionModel(
                    model.id(),
                    model.description(),
                    model.amount(),
                    model.type(),
                    model.date(),
                    null
            );
        }

        CategoryModel existingCategory = categoryGateway.getById(model.category().id());

        return new TransactionModel(
                model.id(),
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                existingCategory
        );
    }
}

