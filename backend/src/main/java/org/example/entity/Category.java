package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
public class Category extends BaseEntity {

    @Setter
    @Getter
    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @OneToMany
    private List<Transactions> transactions;
}
