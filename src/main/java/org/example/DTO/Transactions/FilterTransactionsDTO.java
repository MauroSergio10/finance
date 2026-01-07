package org.example.DTO.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FilterTransactionsDTO(BigDecimal minValue,
                                    BigDecimal maxValue,
                                    LocalDate dataInit,
                                    LocalDate dataEnd,
                                    String description,
                                    Long category
)
{ }
