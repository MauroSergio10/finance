package com.project.transaction_service.application.gateway;

import com.project.transaction_service.domain.model.CategoryModel;

import java.util.Optional;

public interface CategoryGateway {
    CategoryModel create(CategoryModel categoryModel);
    CategoryModel search(CategoryModel categoryModel);
}
