package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookInDTOToBook implements IMapper<BookInDTO, Book>{

    @Override
    public Book map(BookInDTO in){
        Book book = new Book();
        book.setTitle(in.getTitle());
        book.setAuthor(in.getAuthor());
        book.setIsbn(in.getIsbn());
        book.setPublisherHouse(in.getPublisherHouse());
        book.setYearOfPublication(in.getYearOfPublication());
        book.setSummary(in.getSummary());
        book.setAlta(LocalDate.now());
        return book;
    }
}
