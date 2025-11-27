package org.example.controller;

import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryControl {

    private final CategoryService categoryService;

    CategoryControl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category salvar = categoryService.create(category);
        return ResponseEntity.ok(salvar);
    }

    @GetMapping
    public ResponseEntity <List<Category>> listar(){
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> busca(@PathVariable Long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found"));
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete"));
        categoryRepository.delete(category);
        return ResponseEntity.noContent().build();
    }
}
