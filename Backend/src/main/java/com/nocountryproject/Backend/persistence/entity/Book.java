package com.nocountryproject.Backend.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int availableQuantity;
    private String summary;
    //comentario
}
