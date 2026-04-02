package com.project.transaction_service.interfaces.controller;

import com.project.transaction_service.application.usecase.bankaccount.BankAccountCreate;
import com.project.transaction_service.application.usecase.bankaccount.BankAccountDelete;
import com.project.transaction_service.application.usecase.bankaccount.BankAccountGetById;
import com.project.transaction_service.application.usecase.bankaccount.BankAccountListAll;
import com.project.transaction_service.application.usecase.bankaccount.BankAccountUpdate;
import com.project.transaction_service.domain.dto.bankaccount.BankAccountRequest;
import com.project.transaction_service.domain.dto.bankaccount.BankAccountResponse;
import com.project.transaction_service.domain.model.BankAccountModel;
import com.project.transaction_service.interfaces.mapper.BankAccountDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.transaction_service.interfaces.mapper.BankAccountDTOMapper.toModel;

@RestController
@RequestMapping("/bank-accounts")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountCreate bankAccountCreate;
    private final BankAccountUpdate bankAccountUpdate;
    private final BankAccountDelete bankAccountDelete;
    private final BankAccountGetById bankAccountGetById;
    private final BankAccountListAll bankAccountListAll;

    @PostMapping
    public ResponseEntity<BankAccountResponse> createBankAccount(
            @Valid @RequestBody BankAccountRequest request,
            @AuthenticationPrincipal Jwt jwt
            ) {

        String token = jwt.getClaim("sub");

        BankAccountModel created = bankAccountCreate.execute(
            BankAccountDTOMapper.toModel(request, token)
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BankAccountDTOMapper.toResponse(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponse> getBankAccount(@PathVariable Long id) {
        BankAccountModel bankAccount = bankAccountGetById.execute(id);
        return ResponseEntity.ok(
                new BankAccountResponse(bankAccount.id(), bankAccount.name(), bankAccount.balance(), bankAccount.description())
        );
    }

    @GetMapping
    public ResponseEntity<List<BankAccountResponse>> listBankAccounts() {
        List<BankAccountResponse> accounts = bankAccountListAll.execute().stream()
                .map(a -> new BankAccountResponse(a.id(), a.name(), a.balance(), a.description()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankAccountResponse> updateBankAccount(
            @PathVariable Long id,
            @Valid @RequestBody BankAccountRequest request,
            @AuthenticationPrincipal Jwt jwt

    ) {

        String token = jwt.getClaim("sub");

        BankAccountModel model = toModel(request, token);

        BankAccountModel updated = bankAccountUpdate.execute(id, model);

        BankAccountResponse response= (BankAccountDTOMapper.toResponse(updated));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable Long id) {
        bankAccountDelete.execute(id);
        return ResponseEntity.noContent().build();
    }
}

