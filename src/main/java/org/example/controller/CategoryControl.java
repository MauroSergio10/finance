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
        return ResponseEntity.ok(categoryService.create(category));
    }

    @GetMapping
    public ResponseEntity <List<Category>> listAll(){
        return ResponseEntity.ok(categoryService.ListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> search(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.search(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
