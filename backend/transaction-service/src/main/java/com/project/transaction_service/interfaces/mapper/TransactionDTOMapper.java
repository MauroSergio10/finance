package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.dto.transaction.TransactionRequest;
import com.project.transaction_service.domain.dto.transaction.TransactionResponse;
import com.project.transaction_service.domain.model.TransactionModel;

public class TransactionDTOMapper {

    public TransactionModel toModel(TransactionRequest request) {
        return new TransactionModel(
                request.description(),
                request.amount(),
                request.type(),
                request.date()
        );
    }

    public TransactionResponse toDto(TransactionModel model) {
        return new TransactionResponse(
                model.description(),
                model.amount(),
                model.type(),
                model.date()
        );
    }
}