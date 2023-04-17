import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Book } from '../models/book.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private endpoint: string = `${environment.APIUrl}/book`;

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
}
