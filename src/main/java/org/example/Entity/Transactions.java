package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Entity.Category;

import java.math.BigDecimal;

@Entity
@Data
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(length = 100, nullable = false)
    public String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;

}
