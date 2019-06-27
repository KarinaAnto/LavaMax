import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatDialog, MatSnackBar } from '@angular/material';
import { LavanderiaService } from 'src/app/_service/lavanderia.service';
import { Lavanderia} from '../../_model/lavanderia'
// import { DialogoComponent } from './dialogo/dialogo.component';

@Component({
  selector: 'app-lavanderia',
  templateUrl: './lavanderia.component.html',
  styleUrls: ['./lavanderia.component.css']
})
export class LavanderiaComponent implements OnInit {
  
  displayedColumns = ['idLavanderia', 'nombres', 'telefono', 'cantidadLocales', 'acciones'];
  dataSource: MatTableDataSource<Lavanderia>;

  @ViewChild(MatPaginator,{static: false}) paginator: MatPaginator;
  @ViewChild(MatSort,{static: false}) sort: MatSort;

    constructor(private lavanderiaService: LavanderiaService, private snackBar: MatSnackBar) { }

    ngOnInit() {
      this.lavanderiaService.lavanderiaCambio.subscribe(data => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
    this.lavanderiaService.mensaje.subscribe(data => {
      this.snackBar.open(data, 'Aviso', { duration: 2000 });
    });
    this.lavanderiaService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}