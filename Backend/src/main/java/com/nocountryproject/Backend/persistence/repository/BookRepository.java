package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query ("SELECT b FROM Book b WHERE b.title = :title")
    public Book findBookByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.isbn = :isbn")
    public Book findBookByIsbn (@Param("isbn") String isbn);
    
    @Query("SELECT b FROM Book b WHERE b.author = :author")
    public List<Book> listBookByAuthor(@Param ("author") String author);
    
}
