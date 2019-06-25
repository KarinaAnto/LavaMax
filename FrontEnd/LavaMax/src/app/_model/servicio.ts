import { Pago } from './pago';
import { Local } from './local';
import { Estado } from './estado';
import { Producto } from './producto';
import { DetalleProducto } from './detalle-producto';

export class Servicio {
    id:number
    inicio:Date
    fin:Date
    pago:Pago
    // local:Local
    estado:Estado
    detalles:DetalleProducto[]
}
