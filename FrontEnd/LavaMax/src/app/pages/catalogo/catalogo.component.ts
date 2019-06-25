import { Component, OnInit } from '@angular/core';
import { Catalogo } from 'src/app/_model/catalogo';
import { CatalogoService } from 'src/app/_service/catalogo.service';
import { Producto } from 'src/app/_model/producto';
import { ProductoService } from 'src/app/_service/producto.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {

  id:number;
  nombre:string;
  tipo:string;
  // local:Local;
  productos:Producto[]=[];
  productosSeleccionados:Producto[]=[];

  idProductoSeleccionado: number;

  mensaje: string;
  
  constructor(private catalogoService: CatalogoService, private productoService: ProductoService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.listarProdcutos();
  }
  listarProdcutos() {
    this.productoService.listar().subscribe(data => {
      this.productos = data;
    });
  }
  agregarProducto() {
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
        this.mensaje = `El producto se encuentra en la lista`;
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


  aceptar() {

  }


  limpiarControles() {
    this.productosSeleccionados = [];
    this.nombre = '';
    this.tipo = '';
    this.idProductoSeleccionado = 0;
    this.mensaje = '';
  }

  estadoBotonRegistrar() {
    return ( this.idProductoSeleccionado === 0 );
  }


}
