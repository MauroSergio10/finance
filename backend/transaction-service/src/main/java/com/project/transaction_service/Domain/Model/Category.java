package com.project.transaction_service.Domain.Model;

public class Category {

    private final Long id;
    private String name;
    private TransactionType transactionType;

    public Category(Long id, String name, TransactionType transactionType) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }

        this.id = id;
        this.name = name;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()){
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        this.name = newName;
    }

}
