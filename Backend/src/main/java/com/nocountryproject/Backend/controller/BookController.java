package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.service.BookService;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book createBook(@RequestBody BookInDTO bookInDTO){
        return this.bookService.createBook(bookInDTO);
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return this.bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
