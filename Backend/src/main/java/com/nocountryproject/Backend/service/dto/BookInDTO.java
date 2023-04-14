package com.nocountryproject.Backend.service.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class BookInDTO {
    private Long idCategory;
    private String title;
    private String author;
    private String isbn;
    private String publisherHouse;
    private Integer yearOfPublication;
    private String summary;
}
