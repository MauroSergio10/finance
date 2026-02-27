package com.project.transaction_service.domain.dto.transaction;

import com.project.transaction_service.domain.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponse(
        String description,
        BigDecimal amount,
        TransactionType type,
        LocalDate date) {
}
