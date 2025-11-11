package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Transactions> transactions;
}
