import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimengModule } from './primeng/primeng.module';
import { HeaderComponent } from './components/header/header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, PrimengModule, ReactiveFormsModule, HttpClientModule],
  exports: [
    PrimengModule,
    ReactiveFormsModule,
    HeaderComponent,
    HttpClientModule,
  ],
})
export class SharedModule {}
