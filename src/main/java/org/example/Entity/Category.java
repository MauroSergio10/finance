package org.example.Entity;

import jakarta.persistence.*;

import java.util.List;

public class Category {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Category> category;
}
