package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.service.ReservationService;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation makeReservation(@RequestBody ReservationInDTO reservationInDTO) {
        return this.reservationService.makeReservation(reservationInDTO);
    }

    @GetMapping("/{id}")
    public void returnBook(@PathVariable("id") Long id) {
        this.reservationService.returnBook(id);
    }
}
