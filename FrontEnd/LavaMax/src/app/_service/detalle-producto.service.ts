import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { DetalleProducto } from './../_model/detalle-producto';

@Injectable({
  providedIn: 'root'
})
export class DetalleProductoService {

  detalleProductoCambio = new Subject<DetalleProducto[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/detalle-productos`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<DetalleProducto[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<DetalleProducto>(`${this.url}/${id}`);
  }

  registrar(detalleProducto: DetalleProducto) {
    return this.http.post(this.url, detalleProducto);
  }

  modificar(detalleProducto: DetalleProducto) {
    return this.http.put(this.url, detalleProducto);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
