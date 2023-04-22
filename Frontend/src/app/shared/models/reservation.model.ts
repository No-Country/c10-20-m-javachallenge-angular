import { Book } from './book.model';

export interface Reservation {
  id?: number;
  userID: number;
  dni: number;
  username: string;
  book: Book;
  orderNumber: number;
  reservationDate: string;
  expirationDate: string;
  observation: string;
  status: string;
}
