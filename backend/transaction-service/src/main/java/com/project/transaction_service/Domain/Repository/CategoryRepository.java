package com.project.transaction_service.Domain.Repository;

import com.project.transaction_service.Domain.Model.Category;

import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);

    Optional<Category> findById(Long id);
}
