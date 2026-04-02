package com.project.transaction_service.application.usecase.category;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryCreate {

    private final CategoryGateway categoryGateway;

    public CategoryModel execute(CategoryModel model) {
        return categoryGateway.create(model);
    }
}

