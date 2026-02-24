package com.project.transaction_service.Dto;

import com.project.transaction_service.Domain.Model.TransactionType;

import java.math.BigDecimal;

public record TransactionInput(String description, BigDecimal amount, TransactionType type, Long category) { }
