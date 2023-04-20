package com.nocountryproject.Backend.persistence.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@OneToOne
    private Long userId;
    @Nullable
    private Long dni;
    private String userName;
    @OneToOne
    private Book book;
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long orderNumber;
    private LocalDate reservationDate;
    private LocalDate expirationDate;
    private String observation;
    private ReservationStatus status;
}
