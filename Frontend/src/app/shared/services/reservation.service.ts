import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Reservation } from '../models/reservation.model';
import { MakeReservation } from '../models/make-reservation.model';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private endpoint: string = `${environment.APIUrl}/reservation`;

  constructor(private http: HttpClient) {}

  public makeReservation(
    makeReservation: MakeReservation
  ): Observable<Reservation> {
    return this.http.post<Reservation>(this.endpoint, makeReservation);
  }
}
