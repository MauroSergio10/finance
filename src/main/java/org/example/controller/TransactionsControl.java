package org.example.controller;

import org.example.entity.Category;
import org.example.entity.Transactions;
import org.example.exception.NotFoundException;
import org.example.repository.CategoryRepository;
import org.example.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsControl {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Transactions> create(@RequestBody Transactions transactions) {
        Long catID = transactions.getCategory().getId();
        Category category = categoryRepository.findById(catID).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Transactions salvar = transactionsRepository.save(transactions);
        return ResponseEntity.status(201).body(salvar);
    }

    @GetMapping
    public ResponseEntity <List<Transactions>> listar(){
        List<Transactions> transactions = transactionsRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Transactions> buscar(@PathVariable Long id){
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(() -> new NotFoundException("Transação não encontrada"));
        return ResponseEntity.ok(transactions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Transactions transactions = transactionsRepository.findById(id).orElseThrow(() -> new NotFoundException("Transação não encontrada"));
        transactionsRepository.delete(transactions);
        return ResponseEntity.noContent().build();
    }
}
