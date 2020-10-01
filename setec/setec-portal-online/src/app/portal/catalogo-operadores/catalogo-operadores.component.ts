import { Component, OnInit, ViewChild, OnChanges } from '@angular/core';
import { CombosServicio } from 'src/app/shared/objetos/ComboServicio';
import { CatalogoOperadoresService } from '../services/catalogo-operadores.service';
import { ConsultaPerfil, Filtro } from '../services/model/catalogoNacional.model';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { MatTabChangeEvent, MatSort } from '@angular/material';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';



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
  cont: number;

  filtros: Filtro[];
  etiquetaH4: string;

  isClick: boolean;
  isFiltro: boolean;
  isDescripcion: boolean;
  isDataTable: boolean;


  displayedColumns: string[] = [
    'perfil',
    'competeneciaLaboral',
    'familia',
    'sector',
    'descarga',
  ];
  dataSource = new MatTableDataSource<ConsultaPerfil>();
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;





  filtroControl = new FormControl('', [Validators.required]);
  descripcionFormControl = new FormControl('', [Validators.required]);

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

  ngOnInit() {
    this.inicializacionDatos();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

  }



  onLinkClick(event: MatTabChangeEvent) {
    console.log('event => ', event);
    console.log('index => ', event.index);
    console.log('tab => ', event.tab);
  }

  inicializacionDatos() {
    this.isFiltro = false;
    this.isDescripcion = false;
    this.filtro = '';
    this.etiquetaH4 = '';
    this.descripcion = '';
    this.isClick = true;
    this.isDataTable = false;
    this.cont = 0;
    this.consultaPerfil = new ConsultaPerfil();
  }

  seleccionCampo(event: Event) {
    this.filtros = [];
    if (this.campo === '0') {
      this._catalogoOperadoresService.getFamilia().subscribe(data => this.filtros = data);
      this.inicializacionDatos();
      this.isFiltro = true;
      this.etiquetaH4 = 'Filtro';
    } else if (this.campo === '1') {
      this._catalogoOperadoresService.getSector().subscribe(data => this.filtros = data);
      this.inicializacionDatos();
      this.isFiltro = true;
      this.etiquetaH4 = 'Filtro';
    } else if (this.campo === '2') {
      this.inicializacionDatos();
      this.isDescripcion = true;
      this.etiquetaH4 = 'Descripción';
    } else if (this.campo === '3') {
      this.inicializacionDatos();
      this.isClick = false;
    }
  }

  seleccionFiltro(event: Event): boolean {
    if (this.campo === '0' && !(this.filtro === '')) {
      this.isClick = false;
    } else if (this.campo === '1' && !(this.filtro === '')) {
      this.isClick = false;
    } else if (this.campo === '2' && !(this.descripcion === '')) {
      this.isClick = false;
    } else {
      this.isClick = true;
    }

    return this.isClick;
  }


  cargarTablaClick(event: Event) {
    this.cont = 0;
    //   this.consultaPerfiles = [];
    if (this.campo === '0') {
      this.consultaPerfil.campo = this.filtro;
      this.consultaPerfil.opcion = this.campo;
      this._catalogoOperadoresService.obtenerConsultaPerfilPorCampoOEC(this.consultaPerfil).
        subscribe(data => {
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          data.forEach(
            (item, index) => {
              index > 0 ? this.isDataTable = true : this.isDataTable = false;
              //console.log(index);
              // this.consultaPerfiles.push(item);              
            }
          );
        });
    } else if (this.campo === '1') {
      this.consultaPerfil.campo = this.filtro;
      this.consultaPerfil.opcion = this.campo;
      this._catalogoOperadoresService.obtenerConsultaPerfilPorCampoOEC(this.consultaPerfil).
        subscribe(data => {
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          data.forEach(
            (item, index) => {
              index > 0 ? this.isDataTable = true : this.isDataTable = false;
            }
          );
        });

    } else if (this.campo === '2') {
      this.consultaPerfil.campo = this.descripcion;
      this.consultaPerfil.opcion = this.campo;
      this._catalogoOperadoresService.obtenerConsultaPerfilPorCampoOEC(this.consultaPerfil).
        subscribe(data => {
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          data.forEach(
            (item, index) => {
              index > 0 ? this.isDataTable = true : this.isDataTable = false;
            }
          );
        });

    } else if (this.campo === '3') {
      this.consultaPerfil.opcion = this.campo;
      this._catalogoOperadoresService.obtenerConsultaPerfilPorCampoOEC(this.consultaPerfil).
        subscribe(data => {
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          data.forEach(
            (item, index) => {
              index > 0 ? this.isDataTable = true : this.isDataTable = false;
            }
          );
        });

    }



  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }



}
