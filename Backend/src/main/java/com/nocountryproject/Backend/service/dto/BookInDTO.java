package com.nocountryproject.Backend.service.dto;

import jakarta.mail.Multipart;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    //private MultipartFile image;
}
