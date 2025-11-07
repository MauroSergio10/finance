package org.example.Controller;

import org.example.Entity.Category;
import org.example.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryControl {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        Category salvar = transactionsRepository.save(category);
    }
}
