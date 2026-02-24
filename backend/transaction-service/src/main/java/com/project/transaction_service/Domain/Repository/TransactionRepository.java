package com.project.transaction_service.Domain.Repository;

import com.project.transaction_service.Domain.Model.Transaction;

import java.util.List;

public interface TransactionRepository {
    Transaction save(Transaction transaction);

    List<Transaction> findByCategoryId(Long categoryId);
}