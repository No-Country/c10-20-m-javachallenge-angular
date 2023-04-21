import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { AuthService } from 'src/app/login/services/auth.service';
import { FormService } from 'src/app/login/services/form.service';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { JWTResponse } from '../../models/jwtresponse.model';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  menuItems!: MenuItem[];

  userMenuItems!: MenuItem[];
  isLogged: boolean = false;
  user!: User;
  userLogged: string = '';

  categories: Category[] = [];

  constructor(
    private formService: FormService,
    private authService: AuthService,
    private userService: UserService,
    private categoryService: CategoryService,
    private router: Router
  ) {}
  ngOnInit() {
    this.authService.$isLogged.subscribe({
      next: (resp) => {
        this.isLogged = resp;
        const jwt = JSON.parse(localStorage.getItem('jwt')!) as JWTResponse;
        if (jwt?.email) {
          this.userService.findUserByEmail(jwt.email).subscribe({
            next: (resp) => {
              this.userLogged = `${resp.name} ${resp.lastname}`;
            },
          });
          let basePath = 'user/home';
          this.menuItems[0].routerLink = '/user/home';
        }
      },
    });
    this.userMenuItems = [
      {
        label: 'Mis reservas',
        icon: 'pi pi-book',
        routerLink: './user/booking',
      },
      {
        label: 'Cerrar Sesión',
        icon: 'pi pi-sign-out',
        command: () => {
          localStorage.clear();
          this.authService.isLogged(false);
          this.router.navigate(['/login']);
        },
      },
    ];
    this.findAllCategories();
  }

  public login() {
    this.formService.onOpenForm({ type: 'login' });
  }
  public register() {
    this.formService.onOpenForm({ type: 'register' });
  }

  private converCategories(): MenuItem[] {
    const menuItems: MenuItem[] = [];
    this.categories.forEach((c) => {
      const menuItem: MenuItem = {
        label: c.type,
        id: c.id.toString(),
        command: () => {
          this.sendCategoryToSearch(c);
        },
      };
      menuItems.push(menuItem);
    });
    return menuItems;
  }

  private findAllCategories(): void {
    this.categoryService.findAll().subscribe({
      next: (resp) => {
        this.categories = resp.map((c) => {
          c.type = c.type.toUpperCase();
          return c;
        });
        this.createMenu();
      },
    });
  }

  private createMenu(): void {
    this.menuItems = [
      {
        label: 'Home',
        routerLink: './',
      },
      {
        label: 'Categorías',
      },
      {
        label: 'Contáctanos',
        routerLink: './contact',
      },
    ];
    this.menuItems[1].items = this.converCategories();
  }

  private sendCategoryToSearch(category: Category) {
    this.categoryService.setCategory(category);
  }
}
