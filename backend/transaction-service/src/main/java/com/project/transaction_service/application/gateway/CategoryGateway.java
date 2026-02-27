package com.project.transaction_service.application.gateway;

import com.project.transaction_service.domain.model.CategoryModel;

import java.util.List;

public interface CategoryGateway {
    CategoryModel create(CategoryModel categoryModel);
    CategoryModel update(Long id, CategoryModel categoryModel);
    void delete(Long id);
    CategoryModel getById(Long id);
    List<CategoryModel> listAll();
}
