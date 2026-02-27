package com.project.transaction_service.infrastructure.repository;

import com.project.transaction_service.infrastructure.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

