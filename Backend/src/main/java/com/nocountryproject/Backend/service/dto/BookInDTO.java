package com.nocountryproject.Backend.service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookInDTO {
    private String title;
    private String author;
    private String isbn;
    private String publisherHouse;
    private Integer yearOfPublication;
    private String summary;
}
