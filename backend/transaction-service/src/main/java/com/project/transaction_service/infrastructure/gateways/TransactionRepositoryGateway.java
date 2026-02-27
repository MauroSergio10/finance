package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.Category;
import com.project.transaction_service.infrastructure.entity.Transaction;
import com.project.transaction_service.infrastructure.repository.CategoryRepository;
import com.project.transaction_service.infrastructure.repository.TransactionRepository;
import com.project.transaction_service.interfaces.mapper.TransactionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TransactionRepositoryGateway implements TransactionGateway {
    private final TransactionRepository repository;
    private final CategoryRepository categoryRepository;
    private final TransactionEntityMapper mapper;

    public TransactionModel create(TransactionModel model){
        Transaction transaction = new Transaction(
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                category
        );
        transaction = repository.save(transaction);

        return mapper.toModel(transaction);
    }

    @Override
    public TransactionModel update(Long id, TransactionModel model) {
        Transaction transaction = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

        Category category = (model.category() == null || model.category().id() == null)
                ? transaction.getCategory()
                : getCategoryById(model.category().id());

        transaction.update(
                model.description(),
                model.amount(),
                model.type(),
                model.date(),
                category
        );

        transaction = repository.save(transaction);

        return mapper.toModel(transaction);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}
