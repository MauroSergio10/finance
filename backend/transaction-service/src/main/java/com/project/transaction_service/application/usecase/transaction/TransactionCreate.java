package com.project.transaction_service.application.usecase.transaction;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.application.usecase.category.CategoryGetById;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.domain.model.TransactionWithCategoryModel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class TransactionCreate {

    private final TransactionGateway gateway;
    private final CategoryGetById getCategory;

    public TransactionWithCategoryModel execute(TransactionModel model) {

        if (model.amount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        CategoryModel category = null;

        if(model.categoryId() != null){
            category = getCategory.execute(model.categoryId());
        }

        TransactionModel modelCreate = gateway.create(model);

        return new TransactionWithCategoryModel(modelCreate, category);
    }

}

