package com.project.transaction_service.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    public Category(String name) {
        this.name  = name;
    }

    @Getter
    @Column(name = "category_name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions = new ArrayList<>();

    public void rename(String name) {
        this.name = name;
    }
}
