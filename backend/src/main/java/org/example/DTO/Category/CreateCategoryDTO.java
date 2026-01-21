package org.example.DTO.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCategoryDTO(
        @NotNull(message = "Name required")
        @Size(max = 100, message = "Max 100 characters")
        String name
) {
}
