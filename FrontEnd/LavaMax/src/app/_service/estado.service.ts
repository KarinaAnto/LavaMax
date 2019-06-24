import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Estado } from './../_model/estado';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  estadoCambio = new Subject<Estado[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/estados`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Estado[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Estado>(`${this.url}/${id}`);
  }

  registrar(estado: Estado) {
    return this.http.post(this.url, estado);
  }

  modificar(estado: Estado) {
    return this.http.put(this.url, estado);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
