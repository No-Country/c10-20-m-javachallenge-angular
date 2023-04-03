import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { FormService } from 'src/app/login/services/form.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  menuItems!: MenuItem[];

  constructor(private formService: FormService) {}
  ngOnInit() {
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
  }

  public login() {
    this.formService.onOpenForm({ type: 'login' });
  }
  public register() {
    this.formService.onOpenForm({ type: 'register' });
  }
}
