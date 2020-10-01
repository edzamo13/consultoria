import { CatalogoOperadoresComponent } from './catalogo-operadores/catalogo-operadores.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PortalMainComponent } from './portal-main/portal-main.component';
import { MainLayoutComponent } from '../layout/main-layout/main-layout.component';
import { PortalMainCarruselComponent } from './portal-main-carrusel/portal-main-carrusel.component';

const portalRoutes: Routes = [
    {
        path: 'portal',
        component: MainLayoutComponent,
        children: [
            // { path: '', component: PortalContainerComponent, pathMatch: 'full' },
            { path: 'online', component: PortalMainComponent }
        ]
    },
    {
        path: 'portal',
        component: MainLayoutComponent,
        children: [
                      { path: 'catalogoOperadores', component: CatalogoOperadoresComponent, }
        ]
    },
    {
        path: 'portal',
        component: MainLayoutComponent,
        children: [
                      { path: 'online-c', component: PortalMainCarruselComponent, }
        ]
    },

];


@NgModule({
    imports: [
        RouterModule.forChild(portalRoutes)
    ],
    exports: [
        RouterModule,

    ]
})
export class PortalRoutingModule {

}
