package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String name;

    @Column(precision = 12, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false, length = 1000)
    private String userId; //User Account

    @OneToMany
    private List<Transactions> transactions;
}
