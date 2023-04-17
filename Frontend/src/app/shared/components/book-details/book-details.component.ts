import {
  Component,
  EventEmitter,
  Input,
  OnChanges,
  Output,
  SimpleChanges,
} from '@angular/core';
import { Category } from '../../models/category.model';
import { Book } from '../../models/book.model';
import { CategoryService } from '../../services/category.service';
import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss'],
})
export class BookDetailsComponent implements OnChanges {
  @Input() book: Book | undefined;
  category: Category | undefined;
  isLoggedIn: boolean = false;
  @Output() makeRservation: EventEmitter<boolean> = new EventEmitter();

  constructor(
    private categoryService: CategoryService,
    private authService: AuthService
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['book']) {
      this.setCategory();
    }
    this.authService.$isLogged.subscribe({
      next: (resp) => (this.isLoggedIn = resp),
    });
  }

  setCategory(): void {
    if (!this.book) return;
    if (!this.book.id) return;

    const { id } = this.book.category;

    const responseCategory = this.categoryService.findById(id);

    responseCategory.subscribe({
      next: (category) => (this.category = category),
    });
  }
  onMakeRservation() {
    this.makeRservation.emit(true);
  }
}
