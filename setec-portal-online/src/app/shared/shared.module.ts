import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MaterialFormsModule } from './material-forms/material-forms.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  exports: [
    MaterialFormsModule,
    HttpClientModule
  ]
})
export class SharedModule { }
