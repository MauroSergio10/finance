package com.project.transaction_service.application.usecase.category;

import com.project.transaction_service.application.gateway.CategoryGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryDelete {

    private final CategoryGateway categoryGateway;

    public void execute(Long id) {
        categoryGateway.delete(id);
    }
}

