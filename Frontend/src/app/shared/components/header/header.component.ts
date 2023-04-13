import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { AuthService } from 'src/app/login/services/auth.service';
import { FormService } from 'src/app/login/services/form.service';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { JWTResponse } from '../../models/jwtresponse.model';
import { CategoryService } from '../../services/category.service';
import { Category } from '../../models/category.model';

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
    private categoryService: CategoryService
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
        }
      },
    });
    this.userMenuItems = [
      {
        label: 'Cerrar Sesión',
        icon: 'pi pi-sign-out',
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
        command: (event: any) => {
          console.log('Hiciste click');
        },
      },
      {
        label: 'Libros',
      },
      {
        label: 'Contáctanos',
      },
    ];
    this.menuItems[1].items = this.converCategories();
  }

  private sendCategoryToSearch(category: Category) {
    this.categoryService.setCategory(category);
  }
}
