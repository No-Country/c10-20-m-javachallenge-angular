import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/shared/models/categorie.model';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss'],
})
export class CategoriesComponent implements OnInit {
  categories: Categorie[] = [];

  constructor(private http: HttpClient) { };

  getCategories(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(`${environment.APIUrl}/category`);
  }

  ngOnInit(): void {
    this.getCategories().subscribe(dataCategory => {

      this.categories = dataCategory;
    })

  }
}
