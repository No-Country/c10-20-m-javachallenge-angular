package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.BookExceptions;
import com.nocountryproject.Backend.exceptions.CategoryException;
import com.nocountryproject.Backend.mapper.BookInDTOToBook;
import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import net.iharder.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;
    private final BookInDTOToBook mapper;
    private final CategoryService categoryService;

    public BookService(BookRepository repository, BookInDTOToBook mapper, CategoryService categoryService) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    public Book createBook(BookInDTO bookInDTO) throws IOException {

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

    public List<Book> findByIdCategory(Long idCategory){
        Optional<Category> listCategory = categoryService.findById(idCategory);

        if(listCategory.isEmpty()){
            throw new CategoryException("Category not found.", HttpStatus.NOT_FOUND);
        }

        List<Book> listBook = this.repository.findByCategory(listCategory.get());

        if(listBook.isEmpty()){
            throw new BookExceptions("Books not found.", HttpStatus.NOT_FOUND);
        }
        return listBook;
    }

    public List<Book> lastAdded(){
        List<Book> books = this.repository.findAll();
        Collections.sort(books, (Book a, Book b) -> a.getAlta().compareTo(b.getAlta()));
        Collections.reverse(books);
        return books;
    }

    public List<Book> mostRead(){
        List<Book> books = this.repository.findAll();
        Collections.sort(books, (Book a, Book b) ->a.getCant().compareTo(b.getCant()));
        Collections.reverse(books);
        return books;
    }

    public List<Book> findByTitleOrAuthor(String title){
        return this.repository.findByTitleOrAuthor(title);
    }
}
