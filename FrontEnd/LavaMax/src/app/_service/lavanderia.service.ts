import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Lavanderia } from './../_model/lavanderia';

@Injectable({
  providedIn: 'root'
})
export class LavanderiaService {

  lavanderiaCambio = new Subject<Lavanderia[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/lavanderias`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Lavanderia[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Lavanderia>(`${this.url}/${id}`);
  }

  registrar(lavanderia: Lavanderia) {
    return this.http.post(this.url, lavanderia);
  }

  modificar(lavanderia: Lavanderia) {
    return this.http.put(this.url, lavanderia);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
