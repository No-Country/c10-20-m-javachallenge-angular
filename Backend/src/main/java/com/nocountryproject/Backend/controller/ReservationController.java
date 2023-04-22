package com.nocountryproject.Backend.controller;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.persistence.entity.ReservationStatus;
import com.nocountryproject.Backend.service.ReservationService;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Reservation> findAll(){
        return this.reservationService.findAll();
    }

    @GetMapping("/{status}")
    public List<Reservation> findByStatus(@PathVariable ReservationStatus status){
        return this.reservationService.findByStatus(status);
    }

    @GetMapping("/userReservations/{userId}")
    public List<Reservation> reservationsByUser(@PathVariable Long userId){
        return reservationService.reservationsByUser(userId);
    }

    @PutMapping("/change")
    public ResponseEntity<Void> changeReservation(@PathVariable Long id){
        this.reservationService.changeReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long id) {
        this.reservationService.returnBook(id);
        return ResponseEntity.noContent().build();
    }
}

