package com.project.transaction_service.application.usecase.bankaccount;

import com.project.transaction_service.application.gateway.BankAccountGateway;
import com.project.transaction_service.domain.model.BankAccountModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankAccountGetById {

    private final BankAccountGateway bankAccountGateway;

    public BankAccountModel execute(Long id) {
        return bankAccountGateway.getById(id);
    }
}

