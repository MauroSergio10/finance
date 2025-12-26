package org.example.Mapper;


import org.example.DTO.Transactions.CreateTransactionsDTO;
import org.example.DTO.Transactions.TransactionsDTO;
import org.example.entity.Transactions;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface TransactionsMapper {

    TransactionsDTO toDto(Transactions transactions);

    @Mapping(target = "category", ignore = true)
    Transactions toEntity(CreateTransactionsDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "category", ignore = true)
    void updateToEntity(CreateTransactionsDTO dto, @MappingTarget Transactions transactions);
}
