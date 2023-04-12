package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.exceptions.BookExceptions;
import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproject.Backend.service.BookService;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService,
                          BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
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

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long id){
       return this.bookService.findById(id);
    }

    @GetMapping("/books/{idCategory}")
    public List<Book> findBooksByIdCategory(@PathVariable("idCategory") Long idCategory ){
        return this.bookService.findByIdCategory(idCategory);
    }
    @GetMapping("/titleOrAuthor")
    public List<Book> findByTitleOrAuthor(@RequestParam String titleOrAuthor) {
        List<Book> listBook = bookService.findByTitle(titleOrAuthor);
        if (listBook.isEmpty()) {
            listBook = bookService.findByAuthor(titleOrAuthor);
            if(listBook.isEmpty()){
                throw new BookExceptions("Book not found.", HttpStatus.NOT_FOUND);
            }
        }
        return listBook;
    }


}
