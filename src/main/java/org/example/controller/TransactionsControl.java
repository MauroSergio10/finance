package org.example.controller;

import org.example.DTO.Transactions.CreateTransactionsDTO;
import org.example.DTO.Transactions.FilterTransactionsDTO;
import org.example.DTO.Transactions.TransactionsDTO;
import org.example.service.TransactionsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionsControl {

    private final TransactionsService service;

    @PostMapping
    public ResponseEntity<TransactionsDTO> create(@Valid @RequestBody CreateTransactionsDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity <List<TransactionsDTO>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping("/search")
    public ResponseEntity <List<TransactionsDTO>> search(@RequestBody FilterTransactionsDTO dto){
        return ResponseEntity.ok(service.search(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TransactionsDTO> update(@PathVariable Long id,
                                                  @Valid @RequestBody CreateTransactionsDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
