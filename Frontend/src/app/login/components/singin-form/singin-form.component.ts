import { Component, OnInit } from '@angular/core';
import { FormService } from '../../services/form.service';

@Component({
  selector: 'app-singin-form',
  templateUrl: './singin-form.component.html',
  styleUrls: ['./singin-form.component.scss'],
})
export class SinginFormComponent implements OnInit {
  public visible: boolean = false;

  constructor(private formService: FormService) {}

  ngOnInit(): void {
    this.formService.$openForm.subscribe({
      next: (resp) => (this.visible = resp.type === 'login'),
    });
  }
}
