package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.DTO.Account.AccountDTO;
import org.example.DTO.Account.CreateAccountDTO;
import org.example.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountControl {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody CreateAccountDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable Long id,
                                             @Valid @RequestBody CreateAccountDTO dto){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
