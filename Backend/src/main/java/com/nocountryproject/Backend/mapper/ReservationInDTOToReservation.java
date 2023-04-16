package com.nocountryproject.Backend.mapper;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.persistence.repository.UserRepository;
import com.nocountryproject.Backend.service.dto.ReservationInDTO;
import org.springframework.stereotype.Component;

@Component
public class ReservationInDTOToReservation implements IMapper<ReservationInDTO, Reservation> {

    //private final UserRepository userRepository;

  /*public ReservationInDTOToReservation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Override
    public Reservation map(ReservationInDTO in) {
        Reservation reservation = new Reservation();
        reservation.setUserId(in.getUserId());
        reservation.setUserDni(in.getUserDni());
        //reservation.setUserName(userRepository.findById(reservation.getUserId()).get().getName());
        reservation.setBookId(in.getBookId());
        reservation.setReservationDate(reservation.getReservationDate().now());
        reservation.setExpirationDate(reservation.getReservationDate().plusDays(30));
        return reservation;
    }
}
