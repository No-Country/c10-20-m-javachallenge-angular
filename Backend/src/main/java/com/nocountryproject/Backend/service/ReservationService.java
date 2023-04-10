package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproject.Backend.persistence.repository.ReservationRepository;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;

import java.util.Optional;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationInDTO mapper;

    private final BookRepository bookRepository;


    public ReservationService(ReservationRepository reservationRepository, ReservationInDTO mapper, BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
        this.bookRepository = bookRepository;
    }

    public Reservation makeReservation(ReservationInDTO reservationInDTO){
        Reservation reservation = mapper.map(reservationInDTO);
        bookRepository.changeAvailabilityFalse(mapper.getIdBook());
        return this.reservationRepository.save(reservation);
    }

    public void returnBook (Long id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()) {
            throw new RuntimeException("RESERVATION NOT FOUND");
        }
        bookRepository.changeAvailabilityTrue(id);
    }
}
