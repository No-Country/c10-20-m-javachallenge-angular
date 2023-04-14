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
  @Input() book: Book | undefined;
  @Output() close: EventEmitter<boolean> = new EventEmitter<boolean>();
  category: Category | undefined;

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

  setCategory(): void {
    if (!this.book) return;
    if (!this.book.id) return;

    const { idCategory }= this.book;

    const responseCategory = this.categoryService.findById(idCategory);
    
    responseCategory.subscribe({
      next: (category) => this.category = category,
    });
  }
}
