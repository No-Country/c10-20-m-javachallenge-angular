package com.nocountryproject.Backend.service.dto;

import com.nocountryproject.Backend.persistence.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReservationInDTO {

    private Long userId;
    private Long dni;
    private Book book;
    private String observation;
}
