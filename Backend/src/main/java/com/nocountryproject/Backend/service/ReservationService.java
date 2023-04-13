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
import org.springframework.scheduling.annotation.Scheduled;
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

        Optional<Book> optionalBook = bookRepository.findById(reservation.getIdBook());
        optionalBook.get().setAvailability(false);

        return this.reservationRepository.save(reservation);
    }

    public List<Reservation> findAll(){
        return this.reservationRepository.findAll();
    }

    public List<Reservation> findByStatus(ReservationStatus status){
        return this.reservationRepository.findByStatus(status);
    }

    public void changeReservation(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()){
            throw new ReservationExceptions("RESERVATION NOT FOUND");
        }
        optionalReservation.get().setStatus(ReservationStatus.PICKED_UP);
    }

    public void returnBook(Long id) throws ReservationExceptions{
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isEmpty()){
            throw new ReservationExceptions("RESERVATION NOT FOUND");
        }
        optionalReservation.get().setStatus(ReservationStatus.RETURNED);
        Optional<Book> book = bookRepository.findById(optionalReservation.get().getIdBook());
        book.get().setAvailability(true);
    }

    @Scheduled(cron = "0 0 7 * * MON-FRI")
    public void canselReservation(){
        List<Reservation> reservationsList = reservationRepository.findAll();
        for(Reservation reservation : reservationsList){

            Period period = Period.between(reservation.getReservationDate(), LocalDate.now());

            if (period.getDays()>5 && reservation.getStatus() == ReservationStatus.ON_HOLD){
                reservation.setStatus(ReservationStatus.NOT_PICKED_UP);
                Optional<Book> optionalBook = bookRepository.findById(reservation.getIdBook());
                optionalBook.get().setAvailability(true);
            }
            if (period.getDays()>30 && reservation.getStatus() == ReservationStatus.PICKED_UP){
                reservation.setStatus(ReservationStatus.LATE);
            }
        }
    }
}
