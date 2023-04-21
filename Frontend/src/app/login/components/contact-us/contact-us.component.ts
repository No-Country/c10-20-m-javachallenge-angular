import { Component } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';
import { AuthService } from '../../services/auth.service';
import { MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/shared/models/login-user.model';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.scss'],
  providers: [MessageService],
})
export class ContactUsComponent {
  constructor(
    private authService: AuthService,
    private messageService: MessageService,
    private router: Router
  ) {}

  onRegisterUser(user: User): void {
    this.authService.signup(user).subscribe({
      next: (resp) => {
        console.log(resp);
        this.messageService.add({
          severity: 'success',
          summary: '',
          detail: resp.message,
        });
      },
      error: (err) => {
        console.log(err);
        if (err.status === 400) {
          this.messageService.add({
            severity: 'error',
            summary: '',
            detail: err.error.message,
          });
        } else {
          this.messageService.add({
            severity: 'error',
            summary: '',
            detail:
              'Ha ocurrido un error, no se pudo realizar el registro del usuario. Intentelo mas tarde.',
          });
        }
      },
    });
  }

  onLoginUser(user: LoginUser) {
    this.authService.signin(user).subscribe({
      next: (resp) => {
        localStorage.setItem('jwt', JSON.stringify(resp));
        this.authService.isLogged(true);
        this.router.navigate(['/user/home']);
      },
      error: (err) => {
        console.log(err);
        this.messageService.add({
          severity: 'error',
          summary: '',
          detail: err.error.error,
        });
      },
    });
  }
}
