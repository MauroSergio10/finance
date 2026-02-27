package com.project.transaction_service.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    public Category(String name) {
        this.name  = name;
    }

    @Getter
    @Column(name = "categor1y_name", nullable = false, length = 50)
    private String name;
}
