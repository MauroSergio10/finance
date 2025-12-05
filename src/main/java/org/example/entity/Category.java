package org.example.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Transactions> transactions;
}
