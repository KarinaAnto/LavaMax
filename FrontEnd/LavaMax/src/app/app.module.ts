import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LavanderiaComponent } from './pages/lavanderia/lavanderia.component';
import { MaterialModule } from './material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { PacienteEdicionComponent } from './pages/paciente/paciente-edicion/paciente-edicion.component';
import { MedicoComponent } from './pages/medico/medico.component';
import { DialogoComponent } from './pages/medico/dialogo/dialogo.component';
import { ConsultaComponent } from './pages/consulta/consulta.component';
import { DetalleProductoComponent } from './pages/detalle-producto/detalle-producto.component';
import { CatalogoComponent } from './pages/catalogo/catalogo.component';
import { PublicacionesComponent } from './pages/publicaciones/publicaciones.component';
import { ClientesComponent } from './pages/clientes/clientes.component';


@NgModule({
  declarations: [
    AppComponent,
    LavanderiaComponent,
    PacienteEdicionComponent,
    MedicoComponent,
    DialogoComponent,
    ConsultaComponent,
    DetalleProductoComponent,
    CatalogoComponent,
    PublicacionesComponent,
    ClientesComponent
  ],
  entryComponents: [DialogoComponent],
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
