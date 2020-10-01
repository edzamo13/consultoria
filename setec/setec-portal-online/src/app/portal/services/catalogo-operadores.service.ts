import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Filtro, ConsultaPerfil } from './model/catalogoNacional.model';



@Injectable({
  providedIn: 'root'
})
export class CatalogoOperadoresService {

  private urlApi = 'http://localhost:8034/api/';



  constructor(
    private _http: HttpClient
  ) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };


  // HttpClient API get() method => Fetch employee
  public getFamilia(): Observable<Filtro[]> {
    return this._http.get<Filtro[]>(this.urlApi + 'consultaPerfil/listarFamilia')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  public getSector(): Observable<Filtro[]> {
    return this._http.get<Filtro[]>(this.urlApi + 'consultaPerfil/listarSector')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }


  public obtenerConsultaPerfilPorCampoOEC(entrada: ConsultaPerfil): Observable<ConsultaPerfil[]> {
    return this._http.post<ConsultaPerfil[]>
      (this.urlApi + 'consultaPerfil/listarConsultaPerfilPorCampoOEC', JSON.stringify(entrada), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )



  }






  // Error handling 
  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

}

