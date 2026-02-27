package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.dto.category.CategoryResponse;
import com.project.transaction_service.domain.dto.transaction.TransactionRequest;
import com.project.transaction_service.domain.dto.transaction.TransactionResponse;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;

public class TransactionDTOMapper {

    public TransactionResponse toDto(TransactionModel model) {
        return new TransactionResponse(
                model.id(),
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                model.category() == null
                        ? null
                        : new CategoryResponse(model.category().id(), model.category().name())
        );
    }

    public TransactionModel toModel(TransactionRequest request) {
        CategoryModel category = request.categoryId() == null
                ? null
                : new CategoryModel(request.categoryId(), null);

        return new TransactionModel(
                null,
                request.description(),
                request.amount(),
                request.type(),
                request.date(),
                category
        );
    }
}

