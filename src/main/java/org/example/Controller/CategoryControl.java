package org.example.Controller;

import org.example.Entity.Category;
import org.example.Entity.Transactions;
import org.example.Repository.CategoryRepository;
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
        return ResponseEntity.status(200).body(categories);
    }
}
