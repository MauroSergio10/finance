package com.project.transaction_service.infrastructure.config;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.application.gateway.TransactionGateway;
import com.project.transaction_service.application.usecase.category.*;
import com.project.transaction_service.application.usecase.transaction.TransactionCreate;
import com.project.transaction_service.application.usecase.transaction.TransactionDelete;
import com.project.transaction_service.application.usecase.transaction.TransactionUpdate;
import com.project.transaction_service.infrastructure.gateways.CategoryRepositoryGateway;
import com.project.transaction_service.infrastructure.gateways.TransactionRepositoryGateway;
import com.project.transaction_service.infrastructure.repository.CategoryRepository;
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
    TransactionGateway transactionGateway(TransactionRepository transactionRepository,
                                          CategoryRepository categoryRepository,
                                          TransactionEntityMapper transactionEntityMapper) {
        return new TransactionRepositoryGateway(transactionRepository, categoryRepository, transactionEntityMapper);
    }

    @Bean
    TransactionCreate transactionCreate(TransactionGateway transactionGateway,
                                        CategoryGateway categoryGateway) {
        return new TransactionCreate(transactionGateway, categoryGateway);
    }

    @Bean
    TransactionUpdate transactionUpdate(TransactionGateway transactionGateway,
                                        CategoryGateway categoryGateway) {
        return new TransactionUpdate(transactionGateway, categoryGateway);
    }

    @Bean
    TransactionDelete transactionDelete(TransactionGateway transactionGateway) {
        return new TransactionDelete(transactionGateway);
    }

    @Bean
    CategoryGateway categoryGateway(CategoryRepository categoryRepository) {
        return new CategoryRepositoryGateway(categoryRepository);
    }

    @Bean
    CategoryCreate categoryCreate(CategoryGateway categoryGateway) {
        return new CategoryCreate(categoryGateway);
    }

    @Bean
    CategoryUpdate categoryUpdate(CategoryGateway categoryGateway) {
        return new CategoryUpdate(categoryGateway);
    }

    @Bean
    CategoryDelete categoryDelete(CategoryGateway categoryGateway) {
        return new CategoryDelete(categoryGateway);
    }

    @Bean
    CategoryGetById categoryGetById(CategoryGateway categoryGateway) {
        return new CategoryGetById(categoryGateway);
    }

    @Bean
    CategoryListAll categoryListAll(CategoryGateway categoryGateway) {
        return new CategoryListAll(categoryGateway);
    }
}
