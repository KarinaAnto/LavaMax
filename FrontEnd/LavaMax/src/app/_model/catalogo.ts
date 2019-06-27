import { Local } from './local';
import { Producto } from './producto';

export class Catalogo {
    id:number;
    nombre:string;
    tipo:string;
    local:Local
    productos:Producto[]
}
