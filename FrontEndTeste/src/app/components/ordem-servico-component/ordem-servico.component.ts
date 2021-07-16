import { Component, OnInit } from '@angular/core';
import { ExameVO } from 'src/app/classes/exame-vo';
import { MedicoVO } from 'src/app/classes/medico-vo';
import { OrdemServicoObjVO } from 'src/app/classes/ordem-servico-obj-vo';
import { OrdemServicoVO } from 'src/app/classes/ordem-servico-vo';
import { PacienteVO } from 'src/app/classes/paciente-vo';
import { PostoVO } from 'src/app/classes/posto-vo';
import { OrdemServicoService } from 'src/app/services/ordem-servico.service';

@Component({
  selector: 'app-ordem-servico-component',
  templateUrl: './ordem-servico.component.html',
  styleUrls: ['./ordem-servico.component.css']
})
export class OrdemServicoComponent implements OnInit {

  constructor(private ordemService : OrdemServicoService) { }
  mostrar: Boolean = false;
  ordemServico : OrdemServicoVO = new OrdemServicoVO();
  listMedicos: Array<MedicoVO>;
  listPacientes: Array<PacienteVO>;
  listPostos: Array<PostoVO>;
  listExames: Array<ExameVO>;
  exameAdd: number;
  listExamesAdd: Array<ExameVO> = [];
  listagem: Array<OrdemServicoObjVO> = [];
  ngOnInit(): void {
    this.listarOrdens();
    this.ordemService.get("listar_medicos").subscribe((data : Array<MedicoVO>) => this.listMedicos = data);
    this.ordemService.get("listar_pacientes").subscribe((data : Array<PacienteVO>) => this.listPacientes = data);
    this.ordemService.get("listar_postos").subscribe((data : Array<PostoVO>) => this.listPostos = data);
    this.ordemService.get("listar_exames").subscribe((data : Array<ExameVO>) => this.listExames = data);
  }
  adicionarExame(){
    console.log(this.exameAdd);
    let exame: ExameVO = this.listExames.find(o => o.id == this.exameAdd);
    this.listExamesAdd.push(exame);
  }

  novaOrdem(){
    this.ordemServico = new OrdemServicoVO();
    this.mostrar = true;
  }

  salvar(){
    this.ordemServico.exames = this.listExamesAdd.map(o => o.id);
    let retorno : OrdemServicoObjVO;
    this.ordemService.post(this.ordemServico).subscribe((data: OrdemServicoObjVO) =>  {
      console.log(data);
      this.listExamesAdd = [];
      this.listarOrdens();
      this.mostrar = false;
    }, err => alert(err.error));

  }

  listarOrdens(){
    this.ordemService.get("listar").subscribe((data: Array<OrdemServicoObjVO>) => { this.listagem = data; console.log(this.listagem); });
  }

  editOrdem(ordem: OrdemServicoObjVO){
    this.ordemServico.id = ordem.id;
    this.ordemServico.convenio = ordem.convenio;
    this.ordemServico.data = ordem.data;
    this.listExamesAdd = ordem.ordensExames.map(o => o.exame);
    this.ordemServico.medicoId = ordem.medico.id;
    this.ordemServico.pacienteId = ordem.paciente.id;
    this.ordemServico.postoId = ordem.postoColeta.id;
    this.mostrar = true;
  }
  deletar(ordem: OrdemServicoObjVO){
    console.log(ordem);
    let ordemVO: OrdemServicoVO = new OrdemServicoVO();
    ordemVO.id = ordem.id;
    this.ordemService.delete(ordemVO).subscribe((data)=> {
      alert("Excluido com sucesso");
      this.listarOrdens();

    },(err) => alert(err.message));
  }

  deletarExame(exame: ExameVO){
    console.log(this.listExamesAdd);
    this.listExamesAdd.splice(this.listExamesAdd.indexOf(exame),1);
    console.log(this.listExamesAdd);
  }

  cancelar(){
    this.mostrar = false;
  }
}
