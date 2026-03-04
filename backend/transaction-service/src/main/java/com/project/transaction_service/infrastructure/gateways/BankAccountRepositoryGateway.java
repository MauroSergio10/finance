package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.BankAccountGateway;
import com.project.transaction_service.domain.model.BankAccountModel;
import com.project.transaction_service.infrastructure.entity.BankAccount;
import com.project.transaction_service.infrastructure.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class BankAccountRepositoryGateway implements BankAccountGateway {

    private final BankAccountRepository repository;

    @Override
    public BankAccountModel create(BankAccountModel bankAccountModel) {
        BankAccount bankAccount = new BankAccount(
                bankAccountModel.name(),
                bankAccountModel.balance(),
                bankAccountModel.description()
        );
        bankAccount = repository.save(bankAccount);
        return new BankAccountModel(bankAccount.getId(), bankAccount.getName(), bankAccount.getBalance(), bankAccount.getDescription());
    }

    @Override
    public BankAccountModel update(Long id, BankAccountModel bankAccountModel) {
        BankAccount bankAccount = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));

        bankAccount.update(
                bankAccountModel.name(),
                bankAccountModel.balance(),
                bankAccountModel.description()
        );

        bankAccount = repository.save(bankAccount);
        return new BankAccountModel(bankAccount.getId(), bankAccount.getName(), bankAccount.getBalance(), bankAccount.getDescription());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BankAccountModel getById(Long id) {
        BankAccount bankAccount = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bank account not found"));
        return new BankAccountModel(bankAccount.getId(), bankAccount.getName(), bankAccount.getBalance(), bankAccount.getDescription());
    }

    @Override
    public List<BankAccountModel> listAll() {
        return repository.findAll().stream()
                .map(b -> new BankAccountModel(b.getId(), b.getName(), b.getBalance(), b.getDescription()))
                .collect(Collectors.toList());
    }
}

