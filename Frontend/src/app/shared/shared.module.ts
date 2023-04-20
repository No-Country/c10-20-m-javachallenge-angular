import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimengModule } from './primeng/primeng.module';
import { HeaderComponent } from './components/header/header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookViewComponent } from './components/book-view/book-view.component';
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { BookReservationComponent } from './components/book-reservation/book-reservation.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    HeaderComponent,
    BookViewComponent,
    BookDetailsComponent,
    BookReservationComponent,
    FooterComponent,
  ],
  imports: [CommonModule, PrimengModule, ReactiveFormsModule, HttpClientModule],
  exports: [
    PrimengModule,
    ReactiveFormsModule,
    HeaderComponent,
    HttpClientModule,
    BookViewComponent,
    FooterComponent,
  ],
})
export class SharedModule {}
