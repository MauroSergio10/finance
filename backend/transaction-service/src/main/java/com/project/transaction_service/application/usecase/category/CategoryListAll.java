package com.project.transaction_service.application.usecase.category;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryListAll {

    private final CategoryGateway categoryGateway;

    public List<CategoryModel> execute() {
        return categoryGateway.listAll();
    }
}

