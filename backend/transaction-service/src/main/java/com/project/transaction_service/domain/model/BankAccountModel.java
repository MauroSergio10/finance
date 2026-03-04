package com.project.transaction_service.domain.model;

import java.math.BigDecimal;

public record BankAccountModel(
        Long id,
        String name,
        BigDecimal balance,
        String description
) {}

