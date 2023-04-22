import { Book } from './book.model';

export interface MakeReservation {
  userId: number;
  dni: number;
  bookId: Book;
  observation: string;
}
