package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.DTO.CategoryDTO;
import org.example.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryControl {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAll(){
        List<Category> categories = categoryService.ListAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Category> search(@PathVariable Long id){
        Category buscar = categoryService.search(id);
        return ResponseEntity.ok(buscar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> update(
            @PathVariable Long id,
            @RequestBody Map<String, Object> category){

        Category categoryCopy = categoryService.update(id, category);

        return ResponseEntity.ok(categoryCopy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
