package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
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
        if (model.category() != null && model.category().id() != null) {
            category = entityManager.getReference(Category.class, model.category().id());
        }

        Transaction transaction = mapper.toEntity(model, category);
        transaction = repository.save(transaction);
        return mapper.toModel(transaction);
    }

    @Override
    public TransactionModel update(Long id, TransactionModel model) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

        Category category = null;
        if (model.category() != null && model.category().id() != null) {
            category = entityManager.getReference(Category.class, model.category().id());
        }

        Transaction updatedData = mapper.toEntity(model, category);

        transaction.update(
                updatedData.getDescription(),
                updatedData.getAmount(),
                updatedData.getType(),
                updatedData.getDate(),
                updatedData.getCategory()
        );

        transaction = repository.save(transaction);

        return mapper.toModel(transaction);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TransactionModel> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

}
