import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PortalMainComponent } from './portal/portal-main/portal-main.component';
import { AppModule } from './app.module';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { CatalogoOperadoresComponent } from './portal/catalogo-operadores/catalogo-operadores.component';
import { PortalMainCarruselComponent } from './portal/portal-main-carrusel/portal-main-carrusel.component';


const appRoutes: Routes = [
    /* {
         path: '',
         pathMatch: 'full',
         redirectTo: 'portal/online'
     },
     {
         path: '**',
         redirectTo: 'portal/online'
     }*/
    {
        path: 'portal/online',
        component: MainLayoutComponent
    },
    {
        path: '**',
        redirectTo: 'portal/online'

    },
    {
        path: 'portal/catalogoOperadores',
        component: CatalogoOperadoresComponent
    },
    {
        path: 'portal/online-c',
        component: PortalMainCarruselComponent
    },

];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutingModule {
}
