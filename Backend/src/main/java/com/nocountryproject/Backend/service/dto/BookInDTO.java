package com.nocountryproject.Backend.service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookInDTO {
    private String title;
    private String author;
    private Long idCategory;
    private String publisherHouse;
    private String summary;
    private boolean availability;
}
