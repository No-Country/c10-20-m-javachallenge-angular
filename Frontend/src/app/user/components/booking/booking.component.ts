import { Component } from '@angular/core';
import { Reservation } from 'src/app/shared/models/reservation.model';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss'],
})
export class BookingComponent {
  reservations: Reservation[] = [];
}
