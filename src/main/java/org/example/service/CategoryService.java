package org.example.service;

import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.exception.TimeoutException;
import org.example.repository.CategoryRepository;
import org.hibernate.QueryTimeoutException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        try {
            return categoryRepository.save(category);
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

        category.forEach((field, value) ->
            switch (field){
                case "name":
                    update.setName((String) value);
                    break;
                case De
            }
        }
    }

    public void delete(Long id){
        Category deleteData = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete"));
        categoryRepository.delete(deleteData);
    }
}
