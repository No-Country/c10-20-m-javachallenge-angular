import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormService } from '../../services/form.service';
import { LoginUser } from 'src/app/shared/models/login-user.model';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-singin-form',
  templateUrl: './singin-form.component.html',
  styleUrls: ['./singin-form.component.scss'],
})
export class SinginFormComponent implements OnInit {
  @Output() loginUser: EventEmitter<LoginUser> = new EventEmitter<LoginUser>();

  public visible: boolean = false;
  public form!: FormGroup;

  constructor(private formService: FormService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.createForm();
    this.formService.$openForm.subscribe({
      next: (resp) => (this.visible = resp.type === 'login'),
    });
  }

  public register() {
    this.visible = false;
    this.form.reset();
    this.formService.onOpenForm({ type: 'register' });
  }

  public onLogin(): void {
    this.visible = false;
    this.loginUser.emit(this.form.getRawValue() as LoginUser);
    this.formService.onOpenForm({ type: '' });
    this.form.reset();
  }

  private createForm(): void {
    this.form = this.fb.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required]),
      rememberMe: new FormControl(false),
    });
  }
}
