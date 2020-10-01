import { MatTreeFlatDataSource, MatTreeFlattener } from '@angular/material/tree';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule, MatListModule, MatDividerModule, MatTooltipModule } from '@angular/material';
import { TopMenuComponent } from './top-menu/top-menu.component';
import { LeftMenuComponent } from './left-menu/left-menu.component';
import { SharedModule } from '../shared/shared.module';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTreeModule, MatIconModule, MatButtonModule } from '@angular/material'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CatalogoOperadoresComponent } from '../portal/catalogo-operadores/catalogo-operadores.component';




@NgModule({
  declarations: [TopMenuComponent, LeftMenuComponent],
  exports: [TopMenuComponent, LeftMenuComponent],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatListModule,
    MatDividerModule,
    SharedModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatTreeModule, MatIconModule, MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatTooltipModule,


    RouterModule.forChild([])

  ]
})
export class CoreModule { }
