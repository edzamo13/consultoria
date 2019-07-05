import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CombosServicio } from 'src/app/shared/objetos/ComboServicio';
import { CatalogoOperadoresService } from '../services/catalogo-operadores.service';

import { stringify } from '@angular/compiler/src/util';
import { ConsultaPerfil, Filtro } from '../services/model/familia.model';


@Component({
  selector: 'app-catalogo-operadores',
  templateUrl: './catalogo-operadores.component.html',
  styleUrls: ['./catalogo-operadores.component.css']
})
export class CatalogoOperadoresComponent implements OnInit {



  campo: string;
  filtro: string;
  descripcion: string;
  consultaPerfil: ConsultaPerfil;
  filtros: Filtro[];
  etiquetaH4: string;

  isFiltro: boolean;
  isDescripcion: boolean;








  // tiles: InfoServicio[] = [
  listaServicio: CombosServicio[] = [
    { nombre: 'FAMILIA', valor: '0' },
    { nombre: 'SECTOR', valor: '1' },
    { nombre: 'PERFIL', valor: '2' },
    { nombre: 'TOTAL PERFILES', valor: '3' }
  ];

  constructor(
    private _catalogoOperadoresService: CatalogoOperadoresService
  ) {

    
  }




  

  obtenerFamilia(event: Event) {
    console.log('metodo seleccioneServicio');
    console.log('')

  }

  seleccionCampo(event: Event) {
    console.log('evento')
    this.filtros = [];
    if (this.campo === '0') {
      this._catalogoOperadoresService.getFamilia().subscribe(data => this.filtros = data);
      this.isFiltro = true;
      this.isDescripcion = false;
      this.etiquetaH4 = 'Filtro';
    } else if (this.campo === '1') {
      this._catalogoOperadoresService.getSector().subscribe(data => this.filtros = data);
      this.isFiltro = true;
      this.isDescripcion = false;
      this.etiquetaH4 = 'Filtro';
    } else if (this.campo === '2') {
      this.isFiltro = false;
      this.isDescripcion = true;
      this.etiquetaH4 = 'Descripción';
    } else if (this.campo === '3') {
      this.isFiltro = false;
      this.isDescripcion = false;
      this.etiquetaH4 = '';
    }




  }





  ngOnInit() {



  }

}
