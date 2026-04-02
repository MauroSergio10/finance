package com.project.transaction_service.application.usecase.bankaccount;

import com.project.transaction_service.application.gateway.BankAccountGateway;
import com.project.transaction_service.domain.model.BankAccountModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BankAccountListAll {

    private final BankAccountGateway bankAccountGateway;

    public List<BankAccountModel> execute() {
        return bankAccountGateway.listAll();
    }
}

