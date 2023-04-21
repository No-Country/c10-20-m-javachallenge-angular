package com.nocountryproject.Backend.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ReservationExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ReservationExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
