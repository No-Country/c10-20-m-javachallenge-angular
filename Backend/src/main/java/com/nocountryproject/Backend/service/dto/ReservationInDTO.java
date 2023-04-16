package com.nocountryproject.Backend.service.dto;

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
    private Long bookId;
    private String observation;
}
