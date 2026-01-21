package org.example.DTO.Account;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateAccountDTO(
        @NotNull
        @Size(max = 255, message = "Max 255 characters")
        String name,

        @NotNull
        @PositiveOrZero
        Double balance
)
{ }
