package com.project.transaction_service.domain.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryResponse(
        String name
){}
