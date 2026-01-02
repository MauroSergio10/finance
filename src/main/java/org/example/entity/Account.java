package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Account extends BaseEntity {

    @Column(nullable = false, max)
    private String name;
    private Double balance;

    @OneToMany
    private List<Transactions> transactions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
