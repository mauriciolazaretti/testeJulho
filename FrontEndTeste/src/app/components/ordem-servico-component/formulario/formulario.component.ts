import { Input, Output } from '@angular/core';
import { Component, OnInit,EventEmitter } from '@angular/core';
import { ExameVO } from 'src/app/interfaces/exame-vo';
import { MedicoVO } from 'src/app/interfaces/medico-vo';
import { OrdemServicoVO } from 'src/app/interfaces/ordem-servico-vo';
import { PacienteVO } from 'src/app/interfaces/paciente-vo';
import { PostoVO } from 'src/app/interfaces/posto-vo';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  @Input()
  ordemServico : OrdemServicoVO;
  @Input()
  listMedicos: Array<MedicoVO>;
  @Input()
  listPacientes: Array<PacienteVO>;
  @Input()
  listPostos: Array<PostoVO>;
  @Input()
  listExames: Array<ExameVO>;
  exameAdd: number;
  @Input()
  listExamesAdd: Array<ExameVO> = [];

  @Output() eventoSalvar = new EventEmitter<OrdemServicoVO>();
  @Output() eventoCancelar = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }
  adicionarExame(){
    console.log(this.exameAdd);
    let exame: ExameVO = this.listExames.find(o => o.id == this.exameAdd);
    this.listExamesAdd.push(exame);
  }
  deletarExame(exame: ExameVO){
    console.log(this.listExamesAdd);
    this.listExamesAdd.splice(this.listExamesAdd.indexOf(exame),1);
    console.log(this.listExamesAdd);
  }

  salvar(){
    this.ordemServico.exames = this.listExamesAdd.map(o => o.id);
    this.eventoSalvar.emit(this.ordemServico);
  }

  cancelar(){
    this.eventoCancelar.emit();
  }
}
