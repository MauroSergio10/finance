package org.example.Mapper;

import jakarta.transaction.Transaction;
import org.example.DTO.Category.CategoryDTO;
import org.example.DTO.Transactions.CreateTransactionsDTO;
import org.example.DTO.Transactions.TransactionsDTO;
import org.example.entity.Category;
import org.example.entity.Transactions;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface TransactionsMapper {

    TransactionsDTO toDto(Transactions transaction);

    Transactions toEntity(TransactionsDTO transactionsDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateToEntity(CreateTransactionsDTO dto, @MappingTarget Transactions transactions);
}
