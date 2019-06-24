import { Component, OnInit } from '@angular/core';
import { LavanderiaService } from 'src/app/_service/lavanderia.service';
import {Lavanderia} from '../../_model/lavanderia'
@Component({
  selector: 'app-lavanderia',
  templateUrl: './lavanderia.component.html',
  styleUrls: ['./lavanderia.component.css']
})
export class LavanderiaComponent implements OnInit {
  lavanderias: Lavanderia[] = [];
  constructor(private lavanderiaService: LavanderiaService) { }

  ngOnInit() {
    this.lavanderiaService.listar().subscribe(data=>this.lavanderias=data)
    console.log(this.lavanderias)
  }

}
