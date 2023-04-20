package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(Category category);
    @Query("from Book b where upper(b.title) like upper(concat('%', :title,'%')) or upper(b.author) like upper(concat('%', :title,'%')) or upper(b.category.type) like upper(concat('%', :title,'%'))")
    List<Book> findByTitleOrAuthor(@Param("title") String title);
}
