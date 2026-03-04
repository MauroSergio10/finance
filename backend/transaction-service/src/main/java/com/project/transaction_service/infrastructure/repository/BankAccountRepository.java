package com.project.transaction_service.infrastructure.repository;

import com.project.transaction_service.infrastructure.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}

