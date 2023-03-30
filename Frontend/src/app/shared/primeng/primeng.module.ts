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
import { TriStateCheckboxModule } from 'primeng/tristatecheckbox';
import { DividerModule } from 'primeng/divider';

@NgModule({
  imports: [
    ToolbarModule,
    ButtonModule,
    SplitButtonModule,
    TabMenuModule,
    MenubarModule,
    InputTextModule,
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
    TriStateCheckboxModule,
    DividerModule,
  ],
})
export class PrimengModule {}
