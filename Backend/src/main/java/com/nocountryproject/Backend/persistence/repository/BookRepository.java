package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(Long id);

    List<Book> findByAlta(Boolean availability);

    //List<Book> findByCant();
}
