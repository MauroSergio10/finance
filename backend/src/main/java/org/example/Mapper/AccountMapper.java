package org.example.Mapper;

import org.example.DTO.Account.AccountDTO;
import org.example.DTO.Account.CreateAccountDTO;
import org.example.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper{

    AccountDTO toDto(Account account);

    Account toEntity(CreateAccountDTO accountDTO);

}
