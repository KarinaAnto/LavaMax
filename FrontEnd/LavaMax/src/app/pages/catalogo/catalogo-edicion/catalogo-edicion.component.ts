import { Component, OnInit, Inject } from '@angular/core';
import { Catalogo } from 'src/app/_model/catalogo';
import { CatalogoService } from 'src/app/_service/catalogo.service';
import { Producto } from 'src/app/_model/producto';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { MatSnackBar } from '@angular/material';
import { ProductoService } from 'src/app/_service/producto.service';
import { Local } from 'src/app/_model/local';
import { LocalService } from 'src/app/_service/local.service';
MatSnackBar
@Component({
  selector: 'app-catalogo-edicion!',
  templateUrl: './catalogo-edicion.component.html',
  styleUrls: ['./catalogo-edicion.component.css']
})
export class CatalogoEdicionComponent implements OnInit {

  id: number;
  catalogo: Catalogo
  nombre: string
  tipo:string;
  
  localId: number
  local:Local
  
  productos: Producto[] = []
  productosSeleccionados: Producto[] = []
  idProductoSeleccionado: number

  mensaje: string;
  nuevo: boolean = false;
  
  constructor(private route: ActivatedRoute, private router:Router, private snackBar: MatSnackBar,
    private catalogoService: CatalogoService, private productoService: ProductoService,
    private localService: LocalService ){
      this.listarProductos()
     }
  ngOnInit() {    
    this.catalogo = new Catalogo();
    this.route.params.subscribe((params: Params) => {
      this.id = params['id'];      
      this.localId = params['local'];
      this.nuevo = params['id'] == null;
      this.initForm();
    });

    this.listarProductos()
  }
  initForm() {
    if (!this.nuevo) {
      this.catalogoService.listId(this.id).subscribe(data => {
        this.id = data.id,
        this.nombre = data.nombre,
        this.tipo = data.tipo,
        this.productos = data.productos,
        this.local = data.local
        });}
    else{
        this.localService.listId(this.localId).subscribe(data => {
        this.local = data;
      })}
  }
    listarProductos(){
      this.productoService.listar().subscribe(data => {
        this.productos = data;
  })}
  removerProductos(index: number) {
    this.productos.splice(index, 1);
  }

  agregarProductos(){
    if (this.idProductoSeleccionado > 0) {

      let cont = 0;
      for (let i = 0; i < this.productosSeleccionados.length; i++) {
        let producto = this.productosSeleccionados[i];
        if (producto.id === this.idProductoSeleccionado) {
          cont++;
          break;
        }
      }

      if (cont > 0) {
        this.mensaje = `El producto ya se encuentra en la lista`;
        this.snackBar.open(this.mensaje, "Aviso", { duration: 2000 });
      } else {
        let producto = new Producto();
        producto.id = this.idProductoSeleccionado;
        this.productoService.listId(this.idProductoSeleccionado).subscribe(data => {
          producto.nombre = data.nombre;
          this.productosSeleccionados.push(producto);
        });
      }
    } else {
      this.mensaje = `Debe agregar un producto`;
      this.snackBar.open(this.mensaje, "Aviso", { duration: 2000 });
    }
  }

operar(){
  this.catalogo.id=this.id;
  this.catalogo.nombre=this.nombre;
  this.catalogo.tipo=this.tipo;
  this.catalogo.productos= this.productos;

      if (!this.nuevo) {
        this.catalogoService.modificar(this.catalogo).subscribe(
          data => {
            this.catalogoService.listar().subscribe(catalogos => {
              this.catalogoService.catalogoCambio.next(catalogos);
              this.catalogoService.mensaje.next("Se registro");
          });
        });
      } else {
        this.catalogoService.registrar(this.catalogo).subscribe(
          data => {
            this.catalogoService.listar().subscribe(catalogos => {
              this.catalogoService.catalogoCambio.next(catalogos);
              this.catalogoService.mensaje.next("Se registro");
          });
        });
      }
    
    this.router.navigate(['catalogo']);
  }
  estadoBotonRegistrar(){

  }
}
