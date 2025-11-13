package org.example.controller;

import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryControl {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category salvar = categoryRepository.save(category);
        return ResponseEntity.status(200).body(salvar);
    }

    @GetMapping
    public ResponseEntity <List<Category>> listar(){
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> busca(Long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found"));
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete"));
        return ResponseEntity.noContent().build();
    }
}
