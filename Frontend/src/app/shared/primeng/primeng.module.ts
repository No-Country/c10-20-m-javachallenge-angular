import { NgModule } from '@angular/core';
import { ToolbarModule } from 'primeng/toolbar';
import { ButtonModule } from 'primeng/button';
import { SplitButtonModule } from 'primeng/splitbutton';
import { TabMenuModule } from 'primeng/tabmenu';
import { MenubarModule } from 'primeng/menubar';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { CardModule } from 'primeng/card';
import { DialogModule } from 'primeng/dialog';
import { PasswordModule } from 'primeng/password';

import { DividerModule } from 'primeng/divider';
import { CarouselModule } from 'primeng/carousel';
import { ToastModule } from 'primeng/toast';
import { CheckboxModule } from 'primeng/checkbox';
import { MenuModule } from 'primeng/menu';
import { DataViewModule } from 'primeng/dataview';
@NgModule({
  imports: [
    ToolbarModule,
    ButtonModule,
    SplitButtonModule,
    TabMenuModule,
    MenubarModule,
    InputTextModule,
    ToastModule,
  ],
  exports: [
    ToolbarModule,
    ButtonModule,
    SplitButtonModule,
    TabMenuModule,
    MenubarModule,
    InputTextModule,
    DropdownModule,
    CardModule,
    DialogModule,
    PasswordModule,
    DividerModule,
    CarouselModule,
    ToastModule,
    CheckboxModule,
    MenuModule,
    DataViewModule,
  ],
})
export class PrimengModule {}
