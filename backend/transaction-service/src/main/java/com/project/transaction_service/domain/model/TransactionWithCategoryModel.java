package com.project.transaction_service.domain.model;

public record TransactionWithCategoryModel(
    TransactionModel transaction,
    CategoryModel category
) {}
