import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/shared/models/category.model';
import { CategoryService } from 'src/app/shared/services/category.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.scss'],
})
export class HeroComponent implements OnInit {
  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {}
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
}
