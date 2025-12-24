package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.DTO.Transactions.TransactionsDTO;
import org.example.DTO.Transactions.CreateTransactionsDTO;
import org.example.DTO.Transactions.FilterTransactionsDTO;
import org.example.Mapper.TransactionsMapper;
import org.example.entity.Category;
import org.example.entity.Transactions;
import org.example.exception.NotFoundException;
import org.example.repository.CategoryRepository;
import org.example.repository.TransactionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsService {

    private final TransactionsRepository repository;
    private final CategoryRepository categoryRepository;
    private final TransactionsMapper mapper;

    //Update the transaction category
    void applyCategory(CreateTransactionsDTO dto, Transactions t){
        if(dto.category() != null){
            Category saved = categoryRepository.findById(dto.category().id())
                    .orElseThrow(() -> new NotFoundException("Category not found"));
            t.setCategory(saved);
        }
    }

    public TransactionsDTO create(CreateTransactionsDTO newData){
        Transactions newTransactions = mapper.toEntity(newData);

        Category category = categoryRepository.findById(newData.category())
                .orElseThrow(() -> new NotFoundException("Category not found"));


        newTransactions.setCategory(category);


        return mapper.toDto(repository.save(newTransactions));
    }

    public List<TransactionsDTO> listAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<TransactionsDTO> search(FilterTransactionsDTO filter){
            return repository.findAll().stream()
                    .filter(t -> filter.minAmount() == null || filter.minAmount().compareTo(t.getAmount()) <= 0)
                    .filter(t -> filter.maxAmount() == null || filter.maxAmount().compareTo(t.getAmount()) >= 0)
                    .filter(t -> filter.dataInit() == null || filter.dataInit().isBefore(t.getDateTransaction()))
                    .filter(t -> filter.dataEnd() == null || filter.dataEnd().isAfter(t.getDateTransaction()))
                    .filter(t -> filter.today() == null || filter.today().equals(t.getDateTransaction()))
                    .filter(t -> filter.description() == null || filter.description().equals(t.getDescription()))
                    .filter(t-> filter.category() == null || filter.category().equals(t.getCategory().getId()))
                    .map(mapper::toDto)
                    .toList();
    }

    public TransactionsDTO update(Long id, CreateTransactionsDTO dto){
        Transactions transactions = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction not found"));

        mapper.updateToEntity(dto, transactions);
        applyCategory(dto, transactions);

        return mapper.toDto(repository.save(transactions));
    }

    public void delete(Long id){
        Transactions transactions = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("transaction not found"));
        repository.delete(transactions);
    }
}
