import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/shared/models/category.model';
import { CategoryService } from 'src/app/shared/services/category.service';
import { BookService } from 'src/app/shared/services/book.service';
import { Book } from 'src/app/shared/models/book.model';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.scss'],
})
export class HeroComponent implements OnInit {
  categories: Category[] = [];
  books: Book[] = [];
  search = '';

  constructor(private categoryService: CategoryService, private bookService: BookService) {}
  ngOnInit(): void {
    this.findAllCategories();
  }

  private findAllCategories(): void {
    this.categoryService.findAll().subscribe({
      next: (resp) =>
        (this.categories = resp.map((c) => {
          c.type = c.type.toUpperCase();
          return c;
        })),
    });
  }

  principalSearch():void{
    const lista = this.bookService.findByTitleOrAuthorOrCategory(this.search)  

    lista.subscribe(bookList => this.bookService.setBooksList(bookList) );
  }

  onInputChange(event: Event) {
    const inputValue = (event.target as HTMLInputElement).value;
    this.search = inputValue;
  }

}
