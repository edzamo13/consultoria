import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { SharedModule } from './shared/shared.module';
import { PortalModule } from './portal/portal.module';
import { LayoutModule } from './layout/layout.module';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    AppComponent
      ],
  imports: [
    CommonModule,
    BrowserModule,
    CoreModule,
    SharedModule,
    PortalModule,
    RouterModule,
    AppRoutingModule,
    LayoutModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
