package com.project.transaction_service.interfaces.mapper;

import com.project.transaction_service.domain.dto.category.CategoryRequest;
import com.project.transaction_service.domain.dto.category.CategoryResponse;
import com.project.transaction_service.domain.model.CategoryModel;

public class CategoryDTOMapper {

    public static CategoryModel toModel(CategoryRequest request) {
        return new CategoryModel(
            null,
            request.name()
        );
    }

    public static CategoryResponse toResponse(CategoryModel model) {
        return new CategoryResponse(
            model.id(),
            model.name()
        );
    }
}
