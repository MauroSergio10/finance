package org.example.service;

import org.example.DTO.Account.AccountDTO;
import org.example.DTO.Account.CreateAccountDTO;
import org.example.Mapper.AccountMapper;
import org.example.entity.Account;
import org.example.exception.NotFoundException;
import org.example.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    AccountRepository repository;
    AccountMapper mapper;

    public AccountDTO create(CreateAccountDTO newData, String userId){
        Account data = mapper.toEntity(newData);
        data.setUserId(userId);
        return mapper.toDto(repository.save(data));
    }

    public List<AccountDTO> listAll(String userId){
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public AccountDTO findById(Long id){
        Account account = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found"));

        return mapper.toDto(account);
    }

    public AccountDTO update(CreateAccountDTO dto, Long id){
        Account account = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found"));
        return mapper.toDto(repository.save(account));
    }

    public void delete(Long id){
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found to delete")));
    }

}
