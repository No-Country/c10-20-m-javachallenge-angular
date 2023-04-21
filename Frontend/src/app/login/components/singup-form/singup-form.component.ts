import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormService } from '../../services/form.service';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-singup-form',
  templateUrl: './singup-form.component.html',
  styleUrls: ['./singup-form.component.scss'],
})
export class SingupFormComponent implements OnInit {
  @Output() user: EventEmitter<User> = new EventEmitter<User>();

  public visible: boolean = false;
  public form!: FormGroup;

  constructor(private formService: FormService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.createForm();
    this.formService.$openForm.subscribe({
      next: (resp) => (this.visible = resp.type === 'register'),
    });
  }

  public onRegisterUser(): void {
    this.user.emit(this.form.getRawValue() as User);
    this.visible = false;
    this.form.reset();
    this.formService.onOpenForm({ type: '' });
  }
  resetAll() {
    this.form.reset();
    this.visible = false;
    this.formService.onOpenForm({ type: '' });
  }

  private createForm(): void {
    this.form = this.fb.group({
      name: new FormControl('', [Validators.required]),
      lastname: new FormControl('', [Validators.required]),
      dni: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required]),
      telephone: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }
}
