import { Pago } from './pago';
import { Local } from './local';
import { Estado } from './estado';
import { Producto } from './producto';

export class Servicio {
    id:number
    inicio:Date
    fin:Date
    pago:Pago
    local:Local
    estado:Estado
    producto:Producto
}
