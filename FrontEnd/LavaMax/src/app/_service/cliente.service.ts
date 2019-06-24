import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Cliente } from './../_model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  clienteCambio = new Subject<Cliente[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/clientes`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Cliente[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Cliente>(`${this.url}/${id}`);
  }

  registrar(cliente: Cliente) {
    return this.http.post(this.url, cliente);
  }

  modificar(cliente: Cliente) {
    return this.http.put(this.url, cliente);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
