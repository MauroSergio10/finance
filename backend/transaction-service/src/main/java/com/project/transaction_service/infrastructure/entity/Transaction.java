package com.project.transaction_service.infrastructure.entity;

import com.project.transaction_service.domain.model.TransactionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction extends BaseEntity {

    public Transaction(String description, BigDecimal amount, TransactionType type, LocalDate date){
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    @Getter
    @Column(nullable = false, length = 100)
    private String description;

    @Getter
    @Column(nullable = false, precision =  12, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    private TransactionType type;

    @Getter
    private LocalDate date;

}
