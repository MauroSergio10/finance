package org.example.service;

import org.example.entity.Category;
import org.example.exception.TimeoutException;
import org.example.repository.CategoryRepository;
import org.hibernate.QueryTimeoutException;
import org.springframework.stereotype.Service;

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
}
