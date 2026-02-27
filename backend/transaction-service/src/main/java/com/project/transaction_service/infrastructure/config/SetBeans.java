package com.project.transaction_service.infrastructure.config;

import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.application.usecase.TransactionCreate;
import com.project.transaction_service.infrastructure.gateways.TransactionRepositoryGateway;
import com.project.transaction_service.infrastructure.repository.TransactionRepository;
import com.project.transaction_service.interfaces.mapper.TransactionDTOMapper;
import com.project.transaction_service.interfaces.mapper.TransactionEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SetBeans {

    @Bean
    TransactionDTOMapper transactionDTOMapper() {
        return new TransactionDTOMapper();
    }

    @Bean
    TransactionEntityMapper transactionEntityMapper() {
        return new TransactionEntityMapper();
    }

    @Bean
    TransactionGateway transactionGateway(TransactionRepository transactionRepository, TransactionEntityMapper transactionEntityMapper) {
        return new TransactionRepositoryGateway(transactionRepository, transactionEntityMapper);
    }

    @Bean
    TransactionCreate transactionCreate(TransactionGateway transactionGateway) {
        return new TransactionCreate(transactionGateway);
    }

}
