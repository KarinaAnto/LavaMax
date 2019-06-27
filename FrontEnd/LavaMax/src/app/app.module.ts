import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LavanderiaComponent } from './pages/lavanderia/lavanderia.component';
import { MaterialModule } from './material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { DetalleProductoComponent } from './pages/detalle-producto/detalle-producto.component';
import { CatalogoComponent } from './pages/catalogo/catalogo.component';
import { CatalogoEdicionComponent } from './pages/catalogo/catalogo-edicion/catalogo-edicion.component';
import { LavanderiaEdicionComponent } from './pages/lavanderia/lavanderia-edicion/lavanderia-edicion.component';
import { LocalEdicionComponent } from './pages/local/local-edicion/local-edicion.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { ClienteEdicionComponent } from './pages/cliente/cliente-edicion/cliente-edicion.component';
import { ServicioComponent } from './pages/servicio/servicio.component';
import { ServicoEdicionComponent } from './pages/servicio/servico-edicion/servico-edicion.component';
import { PublicacionComponent } from './pages/publicacion/publicacion.component';
import { PublicacionEdicionComponent } from './pages/publicacion/publicacion-edicion/publicacion-edicion.component';
import { TipopagoComponent } from './pages/tipopago/tipopago.component';
import { TipopagoEdicionComponent } from './pages/tipopago/tipopago-edicion/tipopago-edicion.component';
import { PagoComponent } from './pages/pago/pago.component';
import { PagoEdicionComponent } from './pages/pago/pago-edicion/pago-edicion.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { DetalleEdicionComponent } from './pages/detalle-producto/detalle-edicion/detalle-edicion.component';
import { ProductoEdicionComponent } from './pages/producto/producto-edicion/producto-edicion.component';
import { LocalComponent } from './pages/local/local.component';


@NgModule({
  declarations: [
    AppComponent,
    LavanderiaComponent,
    DetalleProductoComponent,
    CatalogoComponent,
    CatalogoEdicionComponent,
    LavanderiaEdicionComponent,
    LocalEdicionComponent,
    ClienteComponent,
    ClienteEdicionComponent,
    ServicioComponent,
    ServicoEdicionComponent,
    PublicacionComponent,
    PublicacionEdicionComponent,
    TipopagoComponent,
    TipopagoEdicionComponent,
    PagoComponent,
    PagoEdicionComponent,
    ProductoComponent,
    DetalleEdicionComponent,
    ProductoEdicionComponent,
    LocalComponent
  ],
  // entryComponents: [DialogoComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
