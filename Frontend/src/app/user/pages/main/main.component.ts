import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
  providers: [MessageService],
})
export class MainComponent {
  constructor(private authService: AuthService, private router: Router) {
    this.authService.$isLogged.subscribe({
      next: (resp) => {
        if (!resp) {
          this.router.navigate(['/login']);
        }
      },
    });
  }
}
