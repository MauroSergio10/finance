package com.project.transaction_service.domain.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank @Size(max = 100, message = "The name must have max 100 characters") String name
){}
