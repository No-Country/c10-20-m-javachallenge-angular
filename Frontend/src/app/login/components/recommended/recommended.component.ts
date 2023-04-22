import { Component, OnInit } from '@angular/core';
import { MenuItem, MessageService } from 'primeng/api';
import { Book } from 'src/app/shared/models/book.model';
import { Category } from 'src/app/shared/models/category.model';
import { BookService } from 'src/app/shared/services/book.service';
import { CategoryService } from 'src/app/shared/services/category.service';

@Component({
  selector: 'app-recommended',
  templateUrl: './recommended.component.html',
  styleUrls: ['./recommended.component.scss'],
})
export class RecommendedComponent implements OnInit {
  tabMenuItems: MenuItem[] = [];
  activeItem!: MenuItem;
  searchTitle: string = '';
  categories: Category[] = [];
  books: Book[] = [];

  bookToShow!: Book;
  openBookView: boolean = false;
  constructor(
    private bookService: BookService,
    private categoryService: CategoryService,
    private messageService: MessageService
  ) {}
  ngOnInit(): void {
    this.createTabMenu();
    this.findAllCategories();
    this.findAllBooks();
    this.searchByCategory();
    this.searchByAuthorOrTitle();
  }
  
  public searchByAuthorOrTitle(){
    this.bookService.$listBooks.subscribe(list => {
      if(list.length > 0) this.books = list;
    }  );
  }

  public onShowBook(book: Book): void {
    console.log(this.openBookView);
    this.bookToShow = book;
    this.openBookView = true;
  }

  private findAllCategories(): void {
    this.categoryService.findAll().subscribe({
      next: (resp) => (this.categories = resp),
    });
  }
  private findAllBooks(): void {
    this.bookService.findAll().subscribe({
      next: (resp) => (this.books = resp),
    });
  }

  private lastAdded(): void {
    this.bookService.lastAdded().subscribe({
      next: (resp) => (this.books = resp),
    });
  }

  private mostRead(): void {
    this.bookService.mostRead().subscribe({
      next: (resp) => (this.books = resp),
    });
  }

  private createTabMenu(): void {
    this.tabMenuItems = [
      {
        label: 'Los más leidos',
        icon: 'pi pi-sort-amount-up',
        id: 't1',
        command: () => {
          this.mostRead();
        },
      },
      {
        label: 'Los más recientes',
        icon: 'pi pi-clock',
        id: 't3',
        command: () => {
          this.lastAdded();
        },
      },
      {
        label: 'Todos los libros',
        icon: 'pi pi-book',
        id: 't4',
        command: () => {
          this.findAllBooks();
        },
      },
    ];
    this.activeItem = this.tabMenuItems[this.tabMenuItems.length - 1];
  }

  public getCategory(id: number): string {
    const category: Category | undefined = this.categories.find(
      (c: Category) => c.id === id
    );

    if (category !== undefined) {
      return category.type;
    }

    return 'No se encontró una categoría para el id seleccionado';
  }

  private searchByCategory(): void {
    this.categoryService.$category.subscribe({
      next: (resp) => {
        let category = resp;
        if (category.id != 0) {
          this.activeItem = {};
          this.bookService.findByCategory(category.id).subscribe({
            next: (resp) => {
              this.books = resp;
              this.searchTitle = `Busqueda por categoria: ${category.type}`;
            },
            error: (err) => {
              this.messageService.add({
                severity: 'error',
                summary: '',
                detail: `No hay libros de la categoria ${resp.type}`,
              });
            },
          });
        }
      },
    });
  }
}
