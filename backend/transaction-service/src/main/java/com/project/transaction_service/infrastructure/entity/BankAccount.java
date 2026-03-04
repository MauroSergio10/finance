package com.project.transaction_service.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankAccount extends BaseEntity {

    public BankAccount(String name,
                       BigDecimal balance,
                       String description) {
        this.name = name;
        this.balance = balance;
        this.description = description;
    }

    @Getter
    @Column(nullable = false, length = 100)
    private String name;

    @Getter
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal balance;

    @Getter
    @Column(nullable = false, length = 255)
    private String description;

    @OneToMany(mappedBy = "bankAccount")
    private List<Transaction> transactions = new ArrayList<>();

    public void update(String name,
                       BigDecimal balance,
                       String description) {
        this.name = name;
        this.balance = balance;
        this.description = description;
    }
}

