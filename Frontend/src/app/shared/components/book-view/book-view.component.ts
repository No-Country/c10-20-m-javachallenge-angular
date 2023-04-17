import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Book } from '../../models/book.model';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.scss'],
})
export class BookViewComponent {
  @Input() visible = false;
  @Input() book: Book | undefined;
  @Output() close: EventEmitter<boolean> = new EventEmitter<boolean>();
  detailActive: boolean = true;
  reservationActive: boolean = false;

  constructor() {}

  onClose() {
    this.visible = false;
    this.close.emit(false);
    this.changeComponent();
  }

  changeComponent() {
    this.detailActive = !this.detailActive;
    this.reservationActive = !this.reservationActive;
  }
}
