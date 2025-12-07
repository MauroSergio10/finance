package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Category.CategoryDTO;
import org.example.DTO.Category.CreateCategoryDTO;
import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO create(CreateCategoryDTO createCategoryDTO) {
        Category entity = new Category();
        entity.setName(createCategoryDTO.name());
        return CategoryDTO.fromEntity(categoryRepository.save(entity));
    }

    public List<CategoryDTO> ListAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::fromEntity)
                .toList();
    }

    public CategoryDTO update(Long id, CreateCategoryDTO newData) {
        Category update = categoryRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Category not found"));
        update.setName(newData.name());
        return CategoryDTO.fromEntity(categoryRepository.save(update));
    }

    public void delete(Long id) {
        categoryRepository.delete(categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete")));
    }
}



