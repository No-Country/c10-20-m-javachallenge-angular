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
    private Long userDni;
    private String userName;
    private Long bookId;
    private String observation;
}
