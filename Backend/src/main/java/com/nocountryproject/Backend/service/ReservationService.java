package com.nocountryproject.Backend.service;

import com.nocountryproject.Backend.exceptions.ReservationExceptions;
import com.nocountryproject.Backend.mapper.ReservationInDTOToReservation;
import com.nocountryproject.Backend.persistence.entity.Book;
import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.persistence.entity.ReservationStatus;
import com.nocountryproject.Backend.persistence.repository.BookRepository;
import com.nocountryproject.Backend.persistence.repository.ReservationRepository;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationInDTOToReservation mapper;

    private final BookRepository bookRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationInDTOToReservation mapper, BookRepository bookRepository, BookRepository bookRepository1) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
        this.bookRepository = bookRepository;
    }

    public Reservation makeReservation(ReservationInDTO reservationInDTO){
        Reservation reservation = mapper.map(reservationInDTO);
        Optional<Book> book = bookRepository.findById(reservation.getIdBook());
        book.get().setAvailability(false);

        return this.reservationRepository.save(reservation);
    }

    public List<Reservation> findAll(){
        return this.reservationRepository.findAll();
    }

    public List<Reservation> listByStatus(ReservationStatus status){
        return this.reservationRepository.listByStatus(status);
    }

    public Reservation changeReservation(Long id) {  //esto lo hace el administrador cuando se llevan el libro
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()){
            throw new ReservationExceptions("RESERVATION NOT FOUND");
        }
        Reservation reservation = optionalReservation.get();
        reservation.setStatus(ReservationStatus.PICKED_UP);
        reservationRepository.save(reservation);
        return reservation;
    }

    public void returnBook(Long id) throws ReservationExceptions { //esto lo hace el administrador cuando devuelven el libro
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()) {
            throw new ReservationExceptions("RESERVATION NOT FOUND");
        }
        optionalReservation.get().setStatus(ReservationStatus.RETURNED);
        Optional<Book> book = bookRepository.findById(optionalReservation.get().getIdBook());
        book.get().setAvailability(true);
    }

    //@Scheduled(cron = "0 0 8 * * MON-FRI")
    public void canselReservation(){
        List<Reservation> reservationList = reservationRepository.findAll();

        for(Reservation reservation : reservationList){
            Period period = Period.between(reservation.getReservationDate(), LocalDate.now());
            if (period.getDays()>5 && reservation.getStatus() == ReservationStatus.ON_HOLD) {
                reservation.setStatus(ReservationStatus.NOT_PICKED_UP);
                Optional<Book> book = bookRepository.findById(reservation.getId());
                book.get().setAvailability(true);
            }
        }
    }

    //@Scheduled(cron = "0 0 8 * * MON-FRI")
    public void lateReturn(){
        List<Reservation> reservationsList = reservationRepository.findAll();

        for (Reservation reservation : reservationsList) {
            Period period = Period.between(reservation.getReservationDate(), LocalDate.now());
            if (period.getDays() > 30 && reservation.getStatus() == ReservationStatus.PICKED_UP){
                reservation.setStatus(ReservationStatus.LATE);
            }
        }
    }
}
