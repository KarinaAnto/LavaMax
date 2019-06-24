import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Catalogo } from './../_model/catalogo';

@Injectable({
  providedIn: 'root'
})
export class CatalogoService {

  catalogoCambio = new Subject<Catalogo[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/catalogos`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Catalogo[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Catalogo>(`${this.url}/${id}`);
  }

  registrar(catalogo: Catalogo) {
    return this.http.post(this.url, catalogo);
  }

  modificar(catalogo: Catalogo) {
    return this.http.put(this.url, catalogo);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}