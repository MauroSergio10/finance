package org.example.DTO.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        @NotNull
        @Size(max = 100, message = "Max 100 characters")
        String name,

        @NotNull
        @Size(max = 254, message = "Max 254 characters")
        @Email
        String Email
)
{ }
