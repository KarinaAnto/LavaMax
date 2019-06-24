import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Pago } from './../_model/pago';

@Injectable({
  providedIn: 'root'
})
export class PagoService {

  pagoCambio = new Subject<Pago[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/pagos`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Pago[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Pago>(`${this.url}/${id}`);
  }

  registrar(pago: Pago) {
    return this.http.post(this.url, pago);
  }

  modificar(pago: Pago) {
    return this.http.put(this.url, pago);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}