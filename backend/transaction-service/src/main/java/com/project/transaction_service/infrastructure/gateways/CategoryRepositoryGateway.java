package com.project.transaction_service.infrastructure.gateways;

import com.project.transaction_service.application.gateway.CategoryGateway;
import com.project.transaction_service.domain.model.CategoryModel;
import com.project.transaction_service.infrastructure.entity.Category;
import com.project.transaction_service.infrastructure.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CategoryRepositoryGateway implements CategoryGateway {

    private final CategoryRepository repository;

    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        Category category = new Category(categoryModel.name());
        category = repository.save(category);
        return new CategoryModel(category.getId(), category.getName());
    }

    @Override
    public CategoryModel update(Long id, CategoryModel categoryModel) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        category.rename(categoryModel.name());
        category = repository.save(category);
        return new CategoryModel(category.getId(), category.getName());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CategoryModel getById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return new CategoryModel(category.getId(), category.getName());
    }

    @Override
    public List<CategoryModel> listAll() {
        return repository.findAll().stream()
                .map(c -> new CategoryModel(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }
}

