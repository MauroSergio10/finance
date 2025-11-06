package org.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<org.example.Entity.Transactions, Long> {
}
