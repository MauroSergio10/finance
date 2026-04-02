package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.dto.transaction.TransactionRequest;
import com.project.transaction_service.domain.dto.transaction.TransactionResponse;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.domain.model.TransactionWithCategoryModel;

public class TransactionDTOMapper {

    public static TransactionModel toModel(TransactionRequest request) {
        return new TransactionModel(
            null,
            request.description(),
            request.amount(),
            request.type(),
            request.date(),
            request.categoryId(),
                null,
            request.bankAccountID()
        );
    }

    public static TransactionResponse toResponse(TransactionWithCategoryModel model) {
        return new TransactionResponse(
                model.transaction().id(),
                model.transaction().description(),
                model.transaction().amount(),
                model.transaction().type(),
                model.transaction().date(),
                model.category().id(),
                model.category().name()
        );
    }
}
