import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Servicio } from './../_model/servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  servicioCambio = new Subject<Servicio[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/servicios`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Servicio[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Servicio>(`${this.url}/${id}`);
  }

  registrar(servicio: Servicio) {
    return this.http.post(this.url, servicio);
  }

  modificar(servicio: Servicio) {
    return this.http.put(this.url, servicio);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}