package com.project.transaction_service.application.usecase.bankaccount;

import com.project.transaction_service.application.gateway.BankAccountGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankAccountDelete {

    private final BankAccountGateway bankAccountGateway;

    public void execute(Long id) {
        bankAccountGateway.delete(id);
    }
}

