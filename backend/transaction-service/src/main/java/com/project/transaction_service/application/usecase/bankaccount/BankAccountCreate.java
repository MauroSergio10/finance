package com.project.transaction_service.application.usecase.bankaccount;

import com.project.transaction_service.application.gateway.BankAccountGateway;
import com.project.transaction_service.domain.model.BankAccountModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankAccountCreate {

    private final BankAccountGateway bankAccountGateway;

    public BankAccountModel execute(BankAccountModel model) {
        return bankAccountGateway.create(model);
    }
}

