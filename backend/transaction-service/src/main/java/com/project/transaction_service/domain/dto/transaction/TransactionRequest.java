package com.project.transaction_service.domain.dto.transaction;

import com.project.transaction_service.domain.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequest(
        @NotBlank @Size(max = 100, message = "Description must have max 100 characters") String description,
        @NotNull(message = "Amount can´t be empty") BigDecimal amount,
        @NotNull(message = "Transaction type can´t be empty") TransactionType type,
        @NotNull(message = "Date can´t be empty") LocalDate date
) {}
