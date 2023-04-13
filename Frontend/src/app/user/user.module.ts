import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { MainComponent } from './pages/main/main.component';
import { LoginModule } from '../login/login.module';

@NgModule({
  declarations: [MainComponent],
  imports: [CommonModule, UserRoutingModule, LoginModule],
})
export class UserModule {}
