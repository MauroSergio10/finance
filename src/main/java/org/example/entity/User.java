package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class User extends BaseEntity{

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 254, nullable = false, unique = true)
    private String email;

    private List<Account> account;

}
