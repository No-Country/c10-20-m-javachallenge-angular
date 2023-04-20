import { Component, Input, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  Validators,
} from '@angular/forms';
import { JWTResponse } from '../../models/jwtresponse.model';
import { UserService } from '../../services/user.service';
import { ReservationService } from '../../services/reservation.service';
import { MakeReservation } from '../../models/make-reservation.model';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-book-reservation',
  templateUrl: './book-reservation.component.html',
  styleUrls: ['./book-reservation.component.scss'],
})
export class BookReservationComponent implements OnInit {
  @Input() bookId!: number;
  @Output() showAlert: boolean = false;
  form!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private reservationService: ReservationService,
    private messageService: MessageService
  ) {}
  userId!: number;

  ngOnInit(): void {
    this.createForm();
    this.getUserIdFromJWT();
  }

  private createForm() {
    this.form = this.fb.group({
      userId: this.userId,
      dni: new FormControl('', Validators.required),
      bookId: this.bookId,
      observation: new FormControl('', Validators.required),
    });
  }

  confirmReservation() {
    const reservation = this.form.getRawValue() as MakeReservation;
    this.reservationService.makeReservation(reservation).subscribe({
      next: (resp) => {
        this.messageService.add({
          severity: 'success',
          summary: '',
          detail: 'Reserva registrada',
        });
      },
    });
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
            this.createForm();
          }
        },
      });
    }
  }
}
