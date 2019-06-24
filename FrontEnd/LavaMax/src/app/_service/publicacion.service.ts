import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';

import { Publicacion } from './../_model/publicacion';

@Injectable({
  providedIn: 'root'
})
export class PublicacionService {

  publicacionCambio = new Subject<Publicacion[]>();
  mensaje = new Subject<string>();

  url: string=`${HOST}/publicaciones`

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Publicacion[]>(this.url);
  }

  listId(id: number) {
    return this.http.get<Publicacion>(`${this.url}/${id}`);
  }

  registrar(publicacion: Publicacion) {
    return this.http.post(this.url, publicacion);
  }

  modificar(publicacion: Publicacion) {
    return this.http.put(this.url, publicacion);
  }

  eliminar(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
}
