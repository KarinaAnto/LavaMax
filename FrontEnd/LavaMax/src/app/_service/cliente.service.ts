import { Injectable } from '@angular/core';
import { HOST } from '../_shared/var.constant';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../_model/cliente';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url: string=`${HOST}/pacientes` //depende del backend
  clienteAux = new Subject<Cliente[]>()

  constructor(private http: HttpClient) { }

  listar = () => this.http.get<Cliente[]>(this.url)
  listarClientePorId = (id:number) => this.http.get<Cliente>(`${this.url}/${id}`)
  registrar = (cliente:Cliente) => this.http.post(this.url, cliente)
  modificar = (cliente:Cliente) => this.http.put(this.url, cliente)
  eliminar = (id:number) => this.http.delete(`${this.url}/${id}`)
}
