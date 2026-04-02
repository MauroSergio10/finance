package com.project.transaction_service.infrastructure.repository;

import com.project.transaction_service.infrastructure.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByBankAccountUserId(String userId);
}
