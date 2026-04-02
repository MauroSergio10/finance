package com.project.transaction_service.infrastructure.mapper;

import com.project.transaction_service.domain.model.BankAccountModel;
import com.project.transaction_service.infrastructure.entity.BankAccount;

public class BankAccountEntityMapper {

    public BankAccountModel toModel(BankAccount account){
        return new BankAccountModel(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getDescription(),
                account.getUserId()
        );
    }
}
