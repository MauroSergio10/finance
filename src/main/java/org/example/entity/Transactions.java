package org.example.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transactions extends BaseEntity{

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
