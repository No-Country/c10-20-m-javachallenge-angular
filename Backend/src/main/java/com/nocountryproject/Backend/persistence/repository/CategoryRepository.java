package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(String type);
}
