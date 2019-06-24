import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSnackBar, MatSort } from '@angular/material';
import { Local } from 'src/app/_model/local';
import { LocalService } from 'src/app/_service/local.service';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.css']
})
export class LocalComponent implements OnInit {

  dataSource: MatTableDataSource<Local>;
  displayedColumns=['idPaciente','nombres','apellidos','acciones'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  cantidad: number;

  constructor(private pacienteService: PacienteService, private snackBar: MatSnackBar) { }

  ngOnInit() {

    this.pacienteService.pacienteCambio.subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

    this.pacienteService.mensajeCambio.subscribe(data => {
      this.snackBar.open(data, 'Aviso', { duration: 2000 });
    });

    /*this.pacienteService.listar().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });*/

    this.pacienteService.listarPageable(0, 10).subscribe(data => {
      console.log(data);
      let pacientes = JSON.parse(JSON.stringify(data)).content;
      this.cantidad = JSON.parse(JSON.stringify(data)).totalElements;
      this.dataSource = new MatTableDataSource(pacientes);
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(filterValue: string){
    filterValue=filterValue.trim();
    filterValue=filterValue.toLowerCase();
    this.dataSource.filter=filterValue;
  }

  eliminar(idPaciente: number) {
    this.pacienteService.eliminar(idPaciente).subscribe(data => {
      this.pacienteService.listar().subscribe(data => {
        this.pacienteService.pacienteCambio.next(data);
        this.pacienteService.mensajeCambio.next('Se eliminó');
      });
    });
  }

  mostrarMas(e: any) {
    console.log(e);
    this.pacienteService.listarPageable(e.pageIndex, e.pageSize).subscribe(data => {
      console.log(data);
      let pacientes = JSON.parse(JSON.stringify(data)).content;
      this.cantidad = JSON.parse(JSON.stringify(data)).totalElements;

      this.dataSource = new MatTableDataSource(pacientes);
      this.dataSource.sort = this.sort;
    });
  }
}

