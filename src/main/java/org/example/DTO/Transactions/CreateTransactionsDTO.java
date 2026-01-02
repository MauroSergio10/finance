package org.example.DTO.Transactions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.example.DTO.Category.CategoryDTO;
import org.example.entity.Category;
import org.example.entity.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionsDTO(
        @NotNull(message = "Valuer is required")
        @PositiveOrZero(message = "Valuer have to be positive")
        BigDecimal value,

        @NotNull(message = "Description is required")
        @Size(max = 255, message = "Max 255 characters")
        String description,

        @NotNull(message = "Data trasaction required")
        LocalDate dateTransaction,

        @NotNull(message = "Category is required")
        Long category)
{ }
