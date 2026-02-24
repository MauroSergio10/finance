package com.project.transaction_service.Dto;

import com.project.transaction_service.Domain.Model.TransactionType;
import jdk.jfr.Category;

import java.math.BigDecimal;

public record TransactionOutput(String description, BigDecimal amount, TransactionType type, Category category) {
}
