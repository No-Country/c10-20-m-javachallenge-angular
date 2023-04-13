import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/shared/models/category.model';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss'],
})
export class CategoriesComponent implements OnInit {
  categories: Category[] = [];
  ngOnInit(): void {
    this.categories = [
      { id: 1, type: 'accion' },
      { id: 2, type: 'aventura' },
      { id: 3, type: 'misterio' },
      { id: 4, type: 'historia' },
      { id: 5, type: 'terror' },
      { id: 6, type: 'anime' },
      { id: 7, type: 'ciencia ficcion' },
    ];
    this.categories.forEach((c) => (c.type = c.type.toLowerCase()));
  }
}
