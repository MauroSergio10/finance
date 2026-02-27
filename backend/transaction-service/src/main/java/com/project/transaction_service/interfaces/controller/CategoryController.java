package com.project.transaction_service.interfaces.controller;

import com.project.transaction_service.application.usecase.category.CategoryCreate;
import com.project.transaction_service.application.usecase.category.CategoryDelete;
import com.project.transaction_service.application.usecase.category.CategoryGetById;
import com.project.transaction_service.application.usecase.category.CategoryListAll;
import com.project.transaction_service.application.usecase.category.CategoryUpdate;
import com.project.transaction_service.domain.dto.category.CategoryRequest;
import com.project.transaction_service.domain.dto.category.CategoryResponse;
import com.project.transaction_service.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryCreate categoryCreate;
    private final CategoryUpdate categoryUpdate;
    private final CategoryDelete categoryDelete;
    private final CategoryGetById categoryGetById;
    private final CategoryListAll categoryListAll;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryModel created = categoryCreate.execute(new CategoryModel(null, categoryRequest.name()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CategoryResponse(created.id(), created.name()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id) {
        CategoryModel category = categoryGetById.execute(id);
        return ResponseEntity.ok(new CategoryResponse(category.id(), category.name()));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategories() {
        List<CategoryResponse> categories = categoryListAll.execute().stream()
                .map(c -> new CategoryResponse(c.id(), c.name()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest categoryRequest
    ) {
        CategoryModel updated = categoryUpdate.execute(id, new CategoryModel(id, categoryRequest.name()));
        return ResponseEntity.ok(new CategoryResponse(updated.id(), updated.name()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryDelete.execute(id);
        return ResponseEntity.noContent().build();
    }
}
