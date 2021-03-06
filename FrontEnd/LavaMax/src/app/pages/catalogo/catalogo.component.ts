import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatSnackBar } from '@angular/material';
import { Catalogo } from 'src/app/_model/catalogo';
import { CatalogoService } from 'src/app/_service/catalogo.service';

@Component({
  selector: 'app-catalogo',
  templateUrl: './catalogo.component.html',
  styleUrls: ['./catalogo.component.css']
})
export class CatalogoComponent implements OnInit {
  
  dataSource: MatTableDataSource<Catalogo>;
  displayedColumns=['idCatalogo','nombre','tipo','acciones'];
  @ViewChild(MatPaginator,null) paginator: MatPaginator;
  @ViewChild(MatSort,null) sort: MatSort;
  cantidad: number;

  constructor(private catalogoService: CatalogoService, private snackBar: MatSnackBar) { }

  ngOnInit() {

    this.catalogoService.catalogoCambio.subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

    this.catalogoService.mensaje.subscribe(data => {
      this.snackBar.open(data, 'Aviso', { duration: 2000 });
    });

    this.catalogoService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
  applyFilter(filterValue: string){
    filterValue=filterValue.trim();
    filterValue=filterValue.toLowerCase();
    this.dataSource.filter=filterValue;
  }
  eliminar(idCatalogo: number) {
    this.catalogoService.eliminar(idCatalogo).subscribe(data => {
      this.catalogoService.listar().subscribe(data => {
        this.catalogoService.catalogoCambio.next(data);
        this.catalogoService.mensaje.next('Se eliminó');
      });
    });
  }

}