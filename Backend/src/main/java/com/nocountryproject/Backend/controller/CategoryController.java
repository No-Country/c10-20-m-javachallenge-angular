package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.service.BookService;
import com.nocountryproject.Backend.service.CategoryService;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import com.nocountryproject.Backend.service.dto.CategoryInDTO;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryInDTO categoryInDTO){
        return this.categoryService.createCategory(categoryInDTO);
    }

    @GetMapping
    public List<Category> findAllBooks(){
        return this.categoryService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
