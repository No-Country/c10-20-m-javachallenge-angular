package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.exceptions.NotFoundException;
import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Category;
import com.nocountryproject.Backend.persistence.repository.CategoryRepository;
import com.nocountryproject.Backend.service.dto.BookInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.time.LocalDate;

@Component
public class BookInDTOToBook implements IMapper<BookInDTO, Book>{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Book map(BookInDTO in) throws IOException {
        Book book = new Book();
        Category category = categoryRepository.findById(in.getIdCategory())
                .orElseThrow(() -> new NotFoundException("Category not found"));
        book.setCategory(category);
        book.setTitle(in.getTitle());
        book.setAuthor(in.getAuthor());
        book.setIsbn(in.getIsbn());
        book.setPublisherHouse(in.getPublisherHouse());
        book.setYearOfPublication(in.getYearOfPublication());
        book.setSummary(in.getSummary());
        book.setAlta(LocalDate.now());
        book.setCant(0);
        //book.setImage(in.getImage().getBytes());

        return book;
    }
}
