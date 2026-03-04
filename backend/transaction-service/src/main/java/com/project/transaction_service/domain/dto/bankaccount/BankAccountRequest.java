package com.project.transaction_service.domain.dto.bankaccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record BankAccountRequest(
        @NotBlank @Size(max = 100, message = "The name must have max 100 characters") String name,
        @NotNull(message = "Balance can´t be empty") BigDecimal balance,
        @NotBlank @Size(max = 255, message = "Description must have max 255 characters") String description
) {}

