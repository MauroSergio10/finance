package org.example.Mapper;

import org.example.DTO.Category.CategoryDTO;
import org.example.DTO.Category.CreateCategoryDTO;
import org.example.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    Category toEntity(CreateCategoryDTO dto);
}
