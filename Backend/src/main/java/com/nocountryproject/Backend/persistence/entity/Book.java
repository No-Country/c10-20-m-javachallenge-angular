package com.nocountryproject.Backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.nocountryproject.Backend.persistence.entity.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Category> idCategory = new ArrayList<>();
    private String title;
    private String author;
    private String isbn; //unique book identifier
    private String publisherHouse;
    private int yearOfPublication;
    private boolean availability;
    private String summary;
}
