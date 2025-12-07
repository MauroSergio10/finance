package org.example.DTO.Transactions;

import org.example.entity.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTransactionsDTO(BigDecimal amount,
                                    String description,
                                    LocalDate dateTransaction,
                                    Long category)
{ }
