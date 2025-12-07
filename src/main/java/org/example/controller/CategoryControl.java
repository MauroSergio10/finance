package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Category.CategoryDTO;
import org.example.DTO.Category.CreateCategoryDTO;
import org.example.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryControl {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO){
        return ResponseEntity.ok(categoryService.create(createCategoryDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listAll(){
        return ResponseEntity.ok(categoryService.ListAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(
            @PathVariable Long id,
            @RequestBody CreateCategoryDTO dto){
        return ResponseEntity.ok(categoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
            categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
