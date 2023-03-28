package com.nocountryproject.Backend.persistence.service;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproyect.Backend.exceptions.MyException;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void createBook(Long idCategory, String title, String author, Long isbn, String publisherHouse, int yearOfPublication, int availableQuantity, String summary) throws MyException {

        validate(idCategory, title, author, isbn, publisherHouse, yearOfPublication, availableQuantity);

        Book book = new Book();

        book.setIdCategory(idCategory);
        book.setTitle(title);
        book.setAuthor(author);
        book.setId(isbn);
        book.setPublisherHouse(publisherHouse);
        book.setYearOfPublication(yearOfPublication);
        book.setSummary(summary);

        bookRepository.save(book);
    }

    public List<Book> bookList() {

        List<Book> books = new ArrayList();

        books = bookRepository.findAll();

        return books;
    }

    @Transactional
    public void editBook(Long idCategory, String title, String author, Long isbn, String publisherHouse, Integer yearOfPublication, Integer availableQuantity, String summary) throws MyException {

        Optional<Book> answer = bookRepository.findById(isbn);

        if (answer.isPresent()) {

            Book book = answer.get();
            book.setIdCategory(idCategory);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisherHouse(publisherHouse);
            book.setYearOfPublication(yearOfPublication);
            book.setSummary(summary);

            bookRepository.save(book);
        } else {
            throw new MyException("No se pudo modificar");
        }

    }
    
    public void validate(Long idCategory, String title, String author, Long isbn, String publisherHouse, Integer yearOfPublication, Integer availableQuantity) throws MyException {

        if (idCategory == null) {
            throw new MyException("no puede estar nulo");
        }
        if (title == null || title.isEmpty()) {
            throw new MyException("no puede estar nulo");
        }
        if (author == null || title.isEmpty()) {
            throw new MyException("no puede estar nulo");
        }
        if (isbn == null) {
            throw new MyException("no puede estar nulo");
        }
        if (publisherHouse == null) {
            throw new MyException("no puede estar nulo");
        }
        if (yearOfPublication == null) {
            throw new MyException("no puede estar nulo");
        }
        if (availableQuantity == null) {
            throw new MyException("no puede estar nulo");
        }
    }
}
