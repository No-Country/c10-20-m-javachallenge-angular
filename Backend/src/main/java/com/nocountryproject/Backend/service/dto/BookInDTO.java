package com.nocountryproject.Backend.service.dto;

import lombok.Data;

@Data
public class BookInDTO {
    private String title;
    private String author;
    private String publisherHouse;
    private String summary;
    private boolean availability;
}
