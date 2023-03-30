import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { MainComponent } from './pages/main/main.component';
import { SharedModule } from '../shared/shared.module';
import { HeroComponent } from './components/hero/hero.component';
import { CategoriesComponent } from './components/categories/categories.component';
import { RecommendedComponent } from './components/recommended/recommended.component';
import { SinginFormComponent } from './components/singin-form/singin-form.component';

@NgModule({
  declarations: [
    MainComponent,
    HeroComponent,
    CategoriesComponent,
    RecommendedComponent,
    SinginFormComponent,
  ],
  imports: [CommonModule, LoginRoutingModule, SharedModule],
})
export class LoginModule {}
