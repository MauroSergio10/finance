package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.dto.bankaccount.BankAccountRequest;
import com.project.transaction_service.domain.dto.bankaccount.BankAccountResponse;
import com.project.transaction_service.domain.model.BankAccountModel;

public class BankAccountDTOMapper {

    public static BankAccountModel toModel(BankAccountRequest request, String token) {
        return new BankAccountModel(
            null,
            request.name(),
            request.balance(),
            request.description(),
            token
        );
    }

    public static BankAccountResponse toResponse(BankAccountModel model) {
        return new BankAccountResponse(
            model.id(),
            model.name(),
            model.balance(),
            model.description()
        );
    }
}
