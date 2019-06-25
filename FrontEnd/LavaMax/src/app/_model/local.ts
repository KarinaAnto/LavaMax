import { Lavanderia } from './lavanderia';
import { Cliente } from './cliente';
import { Servicio } from './servicio';
import { Publicacion } from './publicacion';
import { Catalogo } from './catalogo';

export class Local {
    id:number
    nombres:string
    direccion:string
    telefono:string
    celular:string
    // lavanderia:Lavanderia
    clientes:Cliente[]
    servicios:Servicio[]
    publicaciones:Publicacion[]
    catalogos:Catalogo[]
}
