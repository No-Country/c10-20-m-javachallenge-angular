import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Book } from '../../models/book.model';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category.model';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.scss'],
})
export class BookViewComponent implements OnChanges {
  @Input() visible = false;
  @Input() book!: Book;
  @Output() close: EventEmitter<boolean> = new EventEmitter<boolean>();
  category!: Category;

  constructor(private categoryService: CategoryService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['book']) {
      this.setCategory();
    }
  }

  onClose() {
    this.visible = false;
    this.close.emit(false);
  }
  public setCategory(): void {
    this.categoryService.findById(this.book.id!).subscribe({
      next: (resp) => {
        this.category = resp;
      },
    });
  }
}
