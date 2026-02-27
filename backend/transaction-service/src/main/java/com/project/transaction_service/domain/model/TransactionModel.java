package com.project.transaction_service.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionModel(
        String description,
        BigDecimal amount,
        TransactionType type,
        LocalDate date,
        CategoryModel category
) {}