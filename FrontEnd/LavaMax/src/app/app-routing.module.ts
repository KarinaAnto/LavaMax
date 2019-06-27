import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocalComponent } from './pages/local/local.component';
import { LavanderiaComponent } from './pages/lavanderia/lavanderia.component';
import {LoginComponent} from './pages/login/login.component';
import {RegistroComponent} from './pages/registro/registro.component'
import { LocalEdicionComponent } from './pages/local/local-edicion/local-edicion.component';
import { LavanderiaEdicionComponent } from './pages/lavanderia/lavanderia-edicion/lavanderia-edicion.component';
import { CatalogoEdicionComponent } from './pages/catalogo/catalogo-edicion/catalogo-edicion.component';
import { ClienteEdicionComponent } from './pages/cliente/cliente-edicion/cliente-edicion.component';
import { DetalleProductoComponent } from './pages/detalle-producto/detalle-producto.component';
import { PagoComponent } from './pages/pago/pago.component';
import { PagoEdicionComponent } from './pages/pago/pago-edicion/pago-edicion.component';
import { PublicacionComponent } from './pages/publicacion/publicacion.component';
import { ProductoEdicionComponent } from './pages/producto/producto-edicion/producto-edicion.component';
import { ServicioComponent } from './pages/servicio/servicio.component';
import { CatalogoComponent } from './pages/catalogo/catalogo.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { DetalleEdicionComponent } from './pages/detalle-producto/detalle-edicion/detalle-edicion.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { PublicacionEdicionComponent } from './pages/publicacion/publicacion-edicion/publicacion-edicion.component';
import { ServicoEdicionComponent } from './pages/servicio/servico-edicion/servico-edicion.component';

const routes: Routes = [

  { path:'catalogo', component:CatalogoComponent, children:[
    {path:'nuevo', component:CatalogoEdicionComponent},
    {path:'edicion/:id', component: CatalogoEdicionComponent}] },

  { path:'cliente', component:ClienteComponent, children:[
    {path:'nuevo', component:ClienteEdicionComponent},
    {path:'edicion/:id', component: ClienteEdicionComponent}] },

  { path:'detalle-producto', component:DetalleProductoComponent, children:[
    {path:'nuevo', component:DetalleEdicionComponent},
    {path:'edicion/:id', component: DetalleEdicionComponent}] },

  // { path:'estado', component:EstadoC },
    
  { path:'lavanderia', component:LavanderiaComponent, children:[
    {path:'nuevo', component:LavanderiaEdicionComponent},
    {path:'edicion/:id', component: LavanderiaEdicionComponent}] },
    
  { path:'local', component:LocalComponent, children:[
    {path:'nuevo', component:LocalEdicionComponent},
    {path:'edicion/:id', component: LocalEdicionComponent}] },
    
  { path:'pago', component:PagoComponent, children:[
    {path:'producto', component:PagoEdicionComponent},
    {path:'edicion/:id', component: PagoEdicionComponent}] },
    
  { path:'producto', component:ProductoComponent, children:[
    {path:'nuevo', component:ProductoEdicionComponent},
    {path:'edicion/:id', component: LocalEdicionComponent}] },

  { path:'publicacion', component:PublicacionComponent, children:[
    {path:'nuevo', component:PublicacionEdicionComponent},
    {path:'edicion/:id', component: PublicacionEdicionComponent}] },
      
  { path:'servicio', component:ServicioComponent, children:[
    {path:'nuevo', component:ServicoEdicionComponent},
    {path:'edicion/:id', component: ServicoEdicionComponent}] },

  // { path:'login', component:LoginComponent },
  // { path:'registro', component:RegistroComponent }, 

  // { path:'tipopago', component:TipoPagoComponent }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
