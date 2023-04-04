import { Component, OnInit } from '@angular/core';
import { Categorie } from 'src/app/shared/models/categorie.model';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss'],
})
export class CategoriesComponent implements OnInit {
  categories: Categorie[] = [];
  ngOnInit(): void {
    this.categories = [
      { id: 1, type: 'accion' },
      { id: 2, type: 'aventura' },
      { id: 3, type: 'misterio' },
      { id: 4, type: 'historia' },
    ];
    this.categories.forEach((c) => (c.type = c.type.toLowerCase()));
  }
}