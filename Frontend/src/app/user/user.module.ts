import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { MainComponent } from './pages/main/main.component';
import { LoginModule } from '../login/login.module';
import { SharedModule } from '../shared/shared.module';
import { BookingComponent } from './components/booking/booking.component';

@NgModule({
  declarations: [MainComponent, BookingComponent],
  imports: [CommonModule, UserRoutingModule, LoginModule, SharedModule],
})
export class UserModule {}
