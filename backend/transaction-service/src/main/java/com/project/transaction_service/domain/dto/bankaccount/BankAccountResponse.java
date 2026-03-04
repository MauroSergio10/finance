package com.project.transaction_service.domain.dto.bankaccount;

import java.math.BigDecimal;

public record BankAccountResponse(
        Long id,
        String name,
        BigDecimal balance,
        String description
) {}

