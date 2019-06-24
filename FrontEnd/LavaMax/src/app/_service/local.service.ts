import { Injectable } from '@angular/core';
import { Local } from '../_model/local';
import { Subject } from 'rxjs';
import { HOST } from '../_shared/var.constant';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LocalService {
  url: string=`${HOST}/locales` //depende del backend
  localAux = new Subject<Local[]>()

  constructor(private http: HttpClient) { }

  listar = () => this.http.get<Local[]>(this.url)
  listarLocalPorId = (id:number) => this.http.get<Local>(`${this.url}/${id}`)
  registrar = (local:Local) => this.http.post(this.url, local)
  modificar = (local:Local) => this.http.put(this.url, local)
  eliminar = (id:number) => this.http.delete(`${this.url}/${id}`)
}
