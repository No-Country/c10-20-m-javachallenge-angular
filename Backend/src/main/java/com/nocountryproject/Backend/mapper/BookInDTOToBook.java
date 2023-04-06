package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.stereotype.Component;

@Component
public class BookInDTOToBook implements IMapper<BookInDTO, Book>{

    public Book map(BookInDTO in){
        Book book = new Book();
        book.setTitle(in.getTitle());
        book.setAuthor(in.getAuthor());
        book.setIdCategory(in.getIdCategory());
        book.setIsbn("8145563295-0");
        book.setPublisherHouse(in.getPublisherHouse());
        book.setYearOfPublication(1997);
        book.setAvailability(false);
        return book;
    }
}
