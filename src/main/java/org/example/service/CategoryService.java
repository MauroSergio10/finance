package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.DTO.CategoryDTO;
import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.exception.TimeoutException;
import org.example.repository.CategoryRepository;
import org.hibernate.QueryTimeoutException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO categoryDTO) {
        try {
            Category category = toEntity(categoryDTO);
            return categoryRepository.save(categoryDTO);
        } catch (QueryTimeoutException e) {
            throw new TimeoutException("Tempo de conexão esgotado");
        }
    }

    public List<Category> ListAll(){
        return categoryRepository.findAll();
    }

    public Category search(Long id){
        return categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found"));
    }

    public Category update(Long id, Map<String, Object> category){
        Category update = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found"));

        category.forEach((field, value) -> {
            switch (field) {
                case "name":
                    update.setName((String) value);
                    break;
                default:
                    break;
            }
        });
        return categoryRepository.save(update);
    }

    public void delete(Long id){
        Category deleteData = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete"));
        categoryRepository.delete(deleteData);
    }
}



