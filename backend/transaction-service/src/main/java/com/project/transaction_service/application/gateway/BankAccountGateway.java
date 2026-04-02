package com.project.transaction_service.application.gateway;

import com.project.transaction_service.domain.model.BankAccountModel;

import java.util.List;

public interface BankAccountGateway {
    BankAccountModel create(BankAccountModel bankAccountModel);
    BankAccountModel update(Long id, BankAccountModel bankAccountModel);
    void delete(Long id);
    BankAccountModel getById(Long id);
    List<BankAccountModel> listAll();
}

