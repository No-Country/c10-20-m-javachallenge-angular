package com.nocountryproject.Backend.persistence.repository;

import com.nocountryproject.Backend.persistence.entity.Reservation;
import com.nocountryproject.Backend.persistence.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStatus(ReservationStatus status);

    List<Reservation> findByUserDni(Long userDni);

}
