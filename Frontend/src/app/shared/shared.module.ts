import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimengModule } from './primeng/primeng.module';
import { HeaderComponent } from './components/header/header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BookViewComponent } from './components/book-view/book-view.component';

@NgModule({
  declarations: [HeaderComponent, BookViewComponent],
  imports: [CommonModule, PrimengModule, ReactiveFormsModule, HttpClientModule],
  exports: [
    PrimengModule,
    ReactiveFormsModule,
    HeaderComponent,
    HttpClientModule,
    BookViewComponent,
  ],
})
export class SharedModule {}
