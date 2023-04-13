import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Category } from '../models/category.model';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  private _category: BehaviorSubject<Category> = new BehaviorSubject<Category>({
    id: 0,
    type: '',
  });

  public $category = this._category.asObservable();

  private endpoint: string = `${environment.APIUrl}/category`;
  constructor(private http: HttpClient) {}

  public findAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.endpoint);
  }

  public findById(id: number): Observable<Category> {
    return this.http.get<Category>(`${this.endpoint}/find/${id}`);
  }

  /* CUSTOM OBSERVABLE */
  public setCategory(category: Category): void {
    this._category.next(category);
  }
}
