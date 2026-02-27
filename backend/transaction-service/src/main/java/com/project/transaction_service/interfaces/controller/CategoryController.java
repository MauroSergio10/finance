package com.project.transaction_service.interfaces.controller;

import com.project.transaction_service.domain.dto.category.CategoryRequest;
import com.project.transaction_service.domain.dto.category.CategoryResponse;
import com.project.transaction_service.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {



        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
