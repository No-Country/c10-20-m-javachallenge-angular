import { Component, OnInit } from '@angular/core';
import { FormService } from '../../services/form.service';

@Component({
  selector: 'app-singup-form',
  templateUrl: './singup-form.component.html',
  styleUrls: ['./singup-form.component.scss'],
})
export class SingupFormComponent implements OnInit {
  public visible: boolean = false;

  constructor(private formService: FormService) {}

  ngOnInit(): void {
    this.formService.$openForm.subscribe({
      next: (resp) => (this.visible = resp.type === 'register'),
    });
    console.log('asdad');
  }
}
