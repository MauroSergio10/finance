package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Transactions extends BaseEntity{

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal value;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false)
    private LocalDate dateTransaction;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

}
