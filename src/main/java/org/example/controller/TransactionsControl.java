package org.example.controller;

import org.example.entity.Transactions;
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

    @PostMapping
    public ResponseEntity<Transactions> create(@RequestBody Transactions transactions) {
        Transactions salvar = transactionsRepository.save(transactions);
        return ResponseEntity.status(201).body(salvar);
    }

    @GetMapping
    public ResponseEntity <List<Transactions>> listar(){
        List<Transactions> transactions = transactionsRepository.findAll();
        return ResponseEntity.ok(transactions);
    }
}
