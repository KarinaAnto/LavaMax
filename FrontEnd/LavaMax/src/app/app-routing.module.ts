import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocalComponent } from './pages/local/local.component';
import { LavanderiaComponent } from './pages/lavanderia/lavanderia.component';
import {LoginComponent} from './pages/login/login.component';
import {RegistroComponent} from './pages/registro/registro.component'

const routes: Routes = [
  {
    path:'local', component:LocalComponent
  },
  {
    path:'lavanderia', component:LavanderiaComponent
  },
  {
    path:'login', component:LoginComponent
  },
  {
    path:'registro', component:RegistroComponent
  },  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
