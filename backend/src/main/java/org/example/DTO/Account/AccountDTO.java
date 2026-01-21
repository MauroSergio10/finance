package org.example.DTO.Account;

import org.example.entity.Transactions;

import java.util.List;

public record AccountDTO(Long id,
                         String name,
                         Double balance
)
{ }
