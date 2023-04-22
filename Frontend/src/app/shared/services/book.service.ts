import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Book } from '../models/book.model';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private endpoint: string = `${environment.APIUrl}/book`;

  private _listBooks: BehaviorSubject<Book[]> = new BehaviorSubject<Book[]>([]);

  public $listBooks = this._listBooks.asObservable();

  constructor(private http: HttpClient) {}

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.endpoint);
  }

  public findByCategory(categoryId: number): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.endpoint}/category?id=${categoryId}`);
  }

  public findById(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.endpoint}/${id}`);
  }
  public lastAdded(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.endpoint}/lastAdded`);
  }
  public mostRead(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.endpoint}/lastAdded`);
  }

  public findByTitleOrAuthorOrCategory(search: string): Observable<Book[]>{
    return this.http.get<Book[]>(`${this.endpoint}/findByTitleOrAuthor/${search}`);
  }
  
  public setBooksList(booklist: Book[]): void {
    this._listBooks.next(booklist);
  }
}
