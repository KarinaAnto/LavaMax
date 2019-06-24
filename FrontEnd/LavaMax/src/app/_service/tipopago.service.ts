import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { TipoPago } from './../_model/tipopago';

@Injectable({
  providedIn: 'root'
})
export class TipopagoService {

  tipoPagoCambio = new Subject<TipoPago[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/tiposPago`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<TipoPago[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<TipoPago>(`${this.url}/${id}`);
  }

  registrar(tipoPago: TipoPago) {
    return this.http.post(this.url, tipoPago);
  }

  modificar(tipoPago: TipoPago) {
    return this.http.put(this.url, tipoPago);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}