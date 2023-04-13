package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import org.springframework.stereotype.Component;


@Component
public class ReservationInDTOToReservation implements IMapper<ReservationInDTO, Reservation>{

    @Override
    public Reservation map(ReservationInDTO in) {
        Reservation reservation = new Reservation();
        reservation.setIdUser(reservation.getIdUser());
        reservation.setIdBook(reservation.getIdBook());
        reservation.setReservationDate(reservation.getReservationDate().now());
        reservation.setReservationDate(reservation.getReservationDate().plusDays(30));
        return reservation;
    }
}
