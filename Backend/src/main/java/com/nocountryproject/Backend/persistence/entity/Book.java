package com.nocountryproject.Backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
    private String title;
    private String author;
    private String isbn; //unique book identifier
    private String publisherHouse;
    private int yearOfPublication;
    private boolean availability;
    private String summary;
    private LocalDate alta;
    private Integer cant;
<<<<<<< Updated upstream
    @Lob
    private byte[] image;
=======
    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
>>>>>>> Stashed changes
    @PrePersist
    private void prePersist(){
        availability=true;
    }
}
