package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.BankAccount;
import com.project.transaction_service.infrastructure.entity.Transaction;
import com.project.transaction_service.infrastructure.repository.TransactionRepository;
import com.project.transaction_service.infrastructure.mapper.TransactionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import com.project.transaction_service.infrastructure.entity.Category;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class TransactionRepositoryGateway implements TransactionGateway {
    private final TransactionRepository repository;
    private final TransactionEntityMapper mapper;
    private final EntityManager entityManager;

    @Override
    public TransactionModel create(TransactionModel model){

        Category category = null;

        BankAccount bankAccount = entityManager.getReference(BankAccount.class, model.bankAccountId());

        if (model.categoryId() != null) {
            category = entityManager.getReference(Category.class, model.categoryId());
        }

        Transaction transaction = new Transaction(
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                category,
                bankAccount
        );

        transaction = repository.save(transaction);
        return mapper.toModel(transaction);
    }

    @Override
    public TransactionModel update(Long id, TransactionModel model) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

        BankAccount bankAccount = entityManager.getReference(BankAccount.class, model.bankAccountId());

        Category category = null;
        if (model.categoryId() != null) {
            category = entityManager.getReference(Category.class, model.categoryId());
        }


        transaction.update(
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                category,
                bankAccount
        );

        transaction = repository.save(transaction);

        return mapper.toModel(transaction);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TransactionModel> listAll(String token) {
        return repository.findAllByBankAccountUserId(token)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

}
