import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Local } from './../_model/local';

@Injectable({
  providedIn: 'root'
})
export class LocalService {

  localCambio = new Subject<Local[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/locales`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Local[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Local>(`${this.url}/${id}`);
  }

  registrar(local: Local) {
    return this.http.post(this.url, local);
  }

  modificar(local: Local) {
    return this.http.put(this.url, local);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
