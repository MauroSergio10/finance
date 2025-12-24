package org.example.DTO.Transactions;

import org.example.DTO.Category.CategoryDTO;
import org.example.entity.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionsDTO(Long id,
                              BigDecimal amount,
                              String description,
                              LocalDate dateTransaction,
                              CategoryDTO categoryDTO)
{ }
