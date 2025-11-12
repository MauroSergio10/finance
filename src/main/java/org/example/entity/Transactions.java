package org.example.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(nullable = false, length = 50)
    public String description;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
