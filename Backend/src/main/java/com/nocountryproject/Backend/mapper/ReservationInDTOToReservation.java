package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import org.springframework.stereotype.Component;

@Component
public class ReservationInDTOToReservation implements IMapper<ReservationInDTO, Reservation> {

    @Override
    public Reservation map(ReservationInDTO in) {
        Reservation reservation = new Reservation();
        reservation.setUserDni(in.getUserDni());
        reservation.setUserName(in.getUserName());
        reservation.setBookId(in.getBookId());
        reservation.setReservationDate(reservation.getReservationDate().now());
        reservation.setExpirationDate(reservation.getReservationDate().plusDays(30));
        return reservation;
    }
}
