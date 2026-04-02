package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.domain.model.TransactionWithCategoryModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class TransactionUpdate {

    private final TransactionGateway gateway;
    private final CategoryGateway categoryGateway;

    public TransactionWithCategoryModel execute(Long id, TransactionModel model) {
        if (model.amount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        CategoryModel category = null;
        if (model.categoryId() != null) {
            category = categoryGateway.getById(model.categoryId());
        }

        TransactionModel update = gateway.update(id, model);

        return new TransactionWithCategoryModel(update, category);
    }

}

