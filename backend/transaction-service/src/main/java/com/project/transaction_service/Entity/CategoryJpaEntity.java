package com.project.transaction_service.Entity;

import com.project.transaction_service.Domain.Model.TransactionType;
import jakarta.persistence.*;

@Entity
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransactionType transactionType;
}
