package org.example.DTO.Transactions;


import org.example.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FilterTransactionsDTO(
        BigDecimal minAmount,
        BigDecimal maxAmount,
        LocalDate dataInit,
        LocalDate dataEnd,
        LocalDate today,
        String description,
        Long category
) { }
