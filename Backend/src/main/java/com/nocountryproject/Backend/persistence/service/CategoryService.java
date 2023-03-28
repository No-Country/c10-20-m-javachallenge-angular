package com.nocountryproject.Backend.persistence.service;

import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.persistence.repository.CategoryRepository;
import com.nocountryproyect.Backend.exceptions.MyException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(Long id, String type) throws MyException {

        Optional answer = Optional.ofNullable(categoryRepository.findCategoryByType(type));

        if (answer.isPresent()) {
            throw new MyException("La categoria ya existe");
        } else {
            Category category = new Category();
            category.setType(type);

            categoryRepository.save(category);
        }

    }

}
