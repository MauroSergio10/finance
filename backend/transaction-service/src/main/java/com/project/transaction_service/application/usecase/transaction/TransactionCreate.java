package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class TransactionCreate {

    private final TransactionGateway transactionGateway;
    private final CategoryGateway categoryGateway;

    public TransactionModel execute(TransactionModel model) {

        if (model.amount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        TransactionModel validatedModel = attachExistingCategory(model);

        return transactionGateway.create(validatedModel);
    }

    private TransactionModel attachExistingCategory(TransactionModel model) {
        if (model.category() == null || model.category().id() == null) {
            // categoria opcional: não informar categoryId permite salvar sem categoria
            return new TransactionModel(
                    model.id(),
                    model.description(),
                    model.amount(),
                    model.type(),
                    model.date(),
                    null
            );
        }

        // valida a existência da categoria via gateway de domínio (sem conhecer repository)
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

