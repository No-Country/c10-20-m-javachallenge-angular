package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.BookExceptions;
import com.nocountryproject.Backend.mapper.BookInDTOToBook;
import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;
    private final BookInDTOToBook mapper;

    public BookService(BookRepository repository, BookInDTOToBook mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Book createBook(BookInDTO bookInDTO){
        Book book = mapper.map(bookInDTO);
        return this.repository.save(book);
    }

    public List<Book> findAll(){
        return this.repository.findAll();
    }

    public void deleteById(Long id){
        Optional<Book> optionalBook = this.repository.findById(id);

        if(optionalBook.isEmpty()){
            throw new BookExceptions("Book not found.", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

    public Book findById(Long id){
        Optional<Book> optionalBook = this.repository.findById(id);

        if(optionalBook.isEmpty()){
            throw new BookExceptions("Book not found.", HttpStatus.NOT_FOUND);
        }

        return optionalBook.get();
    }

    public List<Book> findByTitle(String title){

        return this.repository.findByTitle(title);
    }

    public List<Book> findByAuthor(String author){
        return this.repository.findByAuthor(author);

    }

    public List<Book> findByIdCategory(Long id){
        List<Book> listBook = this.repository.findByIdCategory(id);

        if(listBook.isEmpty()){
            throw new BookExceptions("Books not found.", HttpStatus.NOT_FOUND);
        }
        return listBook;
    }

    public List<Book> findByAlta(){
        boolean availability = true;
        List<Book> listBook = this.repository.findByAlta(availability);
        return listBook;
    }

    /*public List<Book> findByCant(){
        List<Book> books = this.repository.findByCant();
        return books;
    }*/
}
