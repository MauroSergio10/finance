package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.DTO.Category.CategoryDTO;
import org.example.DTO.Category.CreateCategoryDTO;
import org.example.Mapper.CategoryMapper;
import org.example.entity.Category;
import org.example.exception.NotFoundException;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryDTO create(CreateCategoryDTO newData) {
        Category entity = mapper.toEntity(newData);
        return mapper.toDto(repository.save(entity));
    }

    public List<CategoryDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public CategoryDTO findById(Long id){
        Category category = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not Found"));
        return mapper.toDto(category);
    }

    public CategoryDTO update(Long id, CreateCategoryDTO dto) {
        Category category = repository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Category not found"));
        category.setName(dto.name());
        return mapper.toDto(repository.save(category));
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id).
                orElseThrow(() -> new NotFoundException("Category not found to delete")));
    }
}



