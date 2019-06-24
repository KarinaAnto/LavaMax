import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Producto } from './../_model/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productoCambio = new Subject<Producto[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/productos`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Producto[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Producto>(`${this.url}/${id}`);
  }

  registrar(producto: Producto) {
    return this.http.post(this.url, producto);
  }

  modificar(producto: Producto) {
    return this.http.put(this.url, producto);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
