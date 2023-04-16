package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.service.CategoryService;
import com.nocountryproject.Backend.service.dto.CategoryInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryInDTO categoryInDTO){
        return this.categoryService.createCategory(categoryInDTO);
    }

    @GetMapping
    public List<Category> findAllCategories(){
        return this.categoryService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{type}")
    public List<Category> findByType(@PathVariable String type){
        return this.categoryService.findByType(type);
    }

    @GetMapping("find/{id}")
    public Optional<Category> findById(@PathVariable("id") Long id){
        return this.categoryService.findById(id);
    }


}
