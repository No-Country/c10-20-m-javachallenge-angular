package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.BookExceptions;
import com.nocountryproject.Backend.exceptions.CategoryException;
import com.nocountryproject.Backend.mapper.CategoryInDTOToCategory;
import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.persistence.repository.CategoryRepository;
import com.nocountryproject.Backend.service.dto.CategoryInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryInDTOToCategory mapper;

    public CategoryService(CategoryRepository repository, CategoryInDTOToCategory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Category createCategory(CategoryInDTO categoryInDTO){
        Category category = mapper.map(categoryInDTO);
        return this.repository.save(category);
    }

    public List<Category> findAll(){
        return this.repository.findAll();
    }

    public void deleteById(Long id){
        Optional<Category> optionalCategory= this.repository.findById(id);

        if(optionalCategory.isEmpty()){
            throw new CategoryException("Category not found.", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

    public List<Category> findByType(String type){
        List<Category> listType = this.repository.findByType(type);

        if(listType.isEmpty()){
            throw new BookExceptions("Type not found.", HttpStatus.NOT_FOUND);
        }
        return listType;
    }

    public Optional<Category> findById(Long id){
        Optional<Category> optionalCategory= this.repository.findById(id);

        if(optionalCategory.isEmpty()){
            throw new CategoryException("Category not found.", HttpStatus.NOT_FOUND);
        }

        return optionalCategory;
    }




}
