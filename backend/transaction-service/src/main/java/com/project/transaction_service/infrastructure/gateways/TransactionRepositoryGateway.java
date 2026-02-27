package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.domain.model.TransactionModel;
import com.project.transaction_service.infrastructure.entity.Transaction;
import com.project.transaction_service.infrastructure.repository.TransactionRepository;
import com.project.transaction_service.interfaces.mapper.TransactionDTOMapper;
import com.project.transaction_service.interfaces.mapper.TransactionEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TransactionRepositoryGateway implements TransactionGateway {
    private final TransactionRepository repository;
    private final TransactionEntityMapper mapper;

    public TransactionModel create(TransactionModel model){
        Transaction transaction = mapper.toEntity(model);
        transaction =  repository.save(transaction);

        return mapper.toModel(transaction);
    }
}
