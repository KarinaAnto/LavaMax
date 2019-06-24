import { Injectable } from '@angular/core';
import { HOST } from '../_shared/var.constant';

@Injectable({
  providedIn: 'root'
})
export class CatalogoService {
  url: string=`${HOST}/catalogos`

  constructor() { }
}
