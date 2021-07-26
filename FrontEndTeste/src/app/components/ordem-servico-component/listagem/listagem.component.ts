import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Component, Input, OnInit } from '@angular/core';
import { ServiceOrderObjVO } from 'src/app/interfaces/service-order-obj-vo';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {
  @Input()
  list: Array<ServiceOrderObjVO>;
  @Output() edicao = new EventEmitter<ServiceOrderObjVO>();
  @Output() exclusao = new EventEmitter<ServiceOrderObjVO>();
  constructor() { }

  ngOnInit(): void {
  }

  edit(ordem : ServiceOrderObjVO){
    this.edicao.emit(ordem);
  }
  delete(ordem : ServiceOrderObjVO){
    this.exclusao.emit(ordem);
  }

}
