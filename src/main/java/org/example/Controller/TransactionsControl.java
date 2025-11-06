package org.example.Controller;

import org.example.Entity.Transactions;
import org.example.Repository.TransactionsRepository;
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
        return ResponseEntity.status(200).body(transactions);
    }
}
