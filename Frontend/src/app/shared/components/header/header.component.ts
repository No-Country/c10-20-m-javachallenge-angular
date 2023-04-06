import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { AuthService } from 'src/app/login/services/auth.service';
import { FormService } from 'src/app/login/services/form.service';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { JWTResponse } from '../../models/jwtresponse.model';

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

  constructor(
    private formService: FormService,
    private authService: AuthService,
    private userService: UserService
  ) {}
  ngOnInit() {
    this.authService.$isLogged.subscribe({
      next: (resp) => {
        this.isLogged = resp;
        const jwt = JSON.parse(localStorage.getItem('jwt')!) as JWTResponse;
        this.userService.findUserByEmail(jwt.email).subscribe({
          next: (resp) => {
            this.userLogged = `${resp.name} ${resp.lastname}`;
          },
        });
      },
    });
    this.menuItems = [
      {
        label: 'Home',
        command: (event: any) => {
          console.log('Hiciste click');
        },
      },

      {
        label: 'Libros',
        items: [
          { label: 'Acción' },
          { label: 'Aventura' },
          { label: 'Misterio' },
          { label: 'Historia' },
        ],
      },
      {
        label: 'Contáctanos',
      },
    ];

    this.userMenuItems = [
      {
        label: 'Cerrar Sesión',
        icon: 'pi pi-sign-out',
      },
    ];
  }

  public login() {
    this.formService.onOpenForm({ type: 'login' });
  }
  public register() {
    this.formService.onOpenForm({ type: 'register' });
  }
}
