package com.nocountryproject.Backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idCategory;
    private String title;
    private String author;
    private String isbn; //unique book identifier
    private String publisherHouse;
    private int yearOfPublication;
    private boolean availability;
    private String summary;
}
