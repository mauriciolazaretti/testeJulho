import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrdemServicoVO } from '../classes/ordem-servico-vo';
import { OrdemServicoObjVO } from '../classes/ordem-servico-obj-vo';
@Injectable({
  providedIn: 'root'
})
export class OrdemServicoService {
  url: string = "http://localhost:8080/"
  constructor(private httpClient: HttpClient) { }

  post(ordemServico: OrdemServicoVO){
    return this.httpClient.post(`${this.url}ordemServico/salvar`, ordemServico);
  }

  get(recurso: string){
    return this.httpClient.get(`${this.url}ordemServico/${recurso}`);
  }

  delete(ordemServico: OrdemServicoVO){
    return this.httpClient.post(`${this.url}ordemServico/deletar`, ordemServico);
  }
}
