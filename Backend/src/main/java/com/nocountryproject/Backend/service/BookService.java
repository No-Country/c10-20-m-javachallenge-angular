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
}
