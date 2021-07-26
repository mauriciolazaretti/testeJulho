import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Component, Input, OnInit } from '@angular/core';
import { OrdemServicoObjVO } from 'src/app/interfaces/ordem-servico-obj-vo';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {
  @Input()
  listagem: Array<OrdemServicoObjVO>;
  @Output() edicao = new EventEmitter<OrdemServicoObjVO>();
  @Output() exclusao = new EventEmitter<OrdemServicoObjVO>();
  constructor() { }

  ngOnInit(): void {
  }

  editOrdem(ordem : OrdemServicoObjVO){
    this.edicao.emit(ordem);
  }
  deletar(ordem : OrdemServicoObjVO){
    this.exclusao.emit(ordem);
  }

}
