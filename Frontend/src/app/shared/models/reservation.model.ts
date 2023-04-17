export interface Reservation {
  id?: number;
  userID: number;
  dni: number;
  username: string;
  bookId: number;
  orderNumber: number;
  reservationDate: string;
  expirationDate: string;
  observation: string;
}
