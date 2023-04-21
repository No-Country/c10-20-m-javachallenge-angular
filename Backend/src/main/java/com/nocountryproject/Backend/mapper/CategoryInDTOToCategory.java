package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.service.dto.CategoryInDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryInDTOToCategory implements IMapper<CategoryInDTO, Category> {

    @Override
    public Category map(CategoryInDTO in){
        Category category = new Category();
        category.setType(in.getType());
        return category;
    }
}
