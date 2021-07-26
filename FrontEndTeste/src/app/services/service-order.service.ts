import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ServiceOrderVO } from '../interfaces/service-order-vo';
import { ServiceOrderObjVO } from '../interfaces/service-order-obj-vo';
@Injectable({
  providedIn: 'root'
})
export class ServiceOrderService {
  url: string = "http://localhost:8080/"
  constructor(private httpClient: HttpClient) { }

  post(serviceOrder: ServiceOrderVO){
    return this.httpClient.post(`${this.url}serviceOrder/save`, serviceOrder);
  }

  get(resource: string){
    return this.httpClient.get(`${this.url}serviceOrder/${resource}`);
  }

  delete(ordemServico: ServiceOrderVO){
    return this.httpClient.post(`${this.url}serviceOrder/delete`, ordemServico);
  }
}
