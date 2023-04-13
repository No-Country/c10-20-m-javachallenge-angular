package com.nocountryproject.Backend.exceptions;

import com.nocountryproject.Backend.service.ReservationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ReservationExceptions extends RuntimeException {
    public ReservationExceptions(String msg) {
        super(msg);
    }
}