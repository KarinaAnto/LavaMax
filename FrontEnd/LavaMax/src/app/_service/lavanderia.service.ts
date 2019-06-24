import { Injectable } from '@angular/core';
import { HOST } from '../_shared/var.constant';
import { Subject } from 'rxjs';
import { Lavanderia } from '../_model/lavanderia';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LavanderiaService {
  url: string=`${HOST}/lavanderias`
  lavanderiaAux = new Subject<Lavanderia[]>()

  constructor(private http: HttpClient) { }

  listar = () => this.http.get<Lavanderia[]>(this.url)
  listarLavanderiaPorId = (id:number) => this.http.get<Lavanderia>(`${this.url}/${id}`)
  registrar = (lavanderia:Lavanderia) => this.http.post(this.url, lavanderia)
  modificar = (lavanderia:Lavanderia) => this.http.put(this.url, lavanderia)
  eliminar = (id:number) => this.http.delete(`${this.url}/${id}`)
}
