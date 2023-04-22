import { Component, OnInit } from '@angular/core';
import { JWTResponse } from 'src/app/shared/models/jwtresponse.model';
import { Reservation } from 'src/app/shared/models/reservation.model';
import { ReservationService } from 'src/app/shared/services/reservation.service';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss'],
})
export class BookingComponent implements OnInit {
  reservations: Reservation[] = [];
  userId!: number;
  constructor(
    private reservationService: ReservationService,
    private userService: UserService
  ) {}
  ngOnInit(): void {
    this.getUserIdFromJWT();
  }

  getUserIdFromJWT() {
    const jwt = JSON.parse(localStorage.getItem('jwt')!) as JWTResponse;
    if (jwt) {
      const email = jwt.email;
      this.userService.findUserByEmail(email).subscribe({
        next: (resp) => {
          console.log(resp);
          if (resp.id) {
            this.userId = resp.id;
            this.reservationService.getByUserId(this.userId).subscribe({
              next: (resp) => {
                this.reservations = resp;
                console.log(resp);
              },
            });
          }
        },
      });
    }
  }
}
