import { Catalogo  } from './catalogo';
import { Servicio } from './servicio';
import { DetalleProducto } from './detalle-producto';

export class Producto {
    id:number
    nombre:string
    // catalogo:Catalogo
    // servicio:Servicio
    precioKilo:number
    detalles:DetalleProducto[]
}
