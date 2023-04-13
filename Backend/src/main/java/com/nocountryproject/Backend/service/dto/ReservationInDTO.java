package com.nocountryproject.Backend.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReservationInDTO {
    private Long idUser;
    private Long idBook;
    private LocalDateTime reservationDate;
    private LocalDateTime expirationDate;
}
