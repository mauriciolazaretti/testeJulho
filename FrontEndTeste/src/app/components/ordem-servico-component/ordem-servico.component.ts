import { Component, OnInit } from '@angular/core';
import { ExamVO } from 'src/app/interfaces/exam-vo';
import { DoctorVO } from 'src/app/interfaces/doctor-vo';
import { ServiceOrderObjVO } from 'src/app/interfaces/service-order-obj-vo';
import { ServiceOrderVO } from 'src/app/interfaces/service-order-vo';
import { PatientVO } from 'src/app/interfaces/patient-vo';
import { CollectionPostVO } from 'src/app/interfaces/collection-post-vo';
import { ServiceOrderService } from 'src/app/services/service-order.service';

@Component({
  selector: 'app-ordem-servico-component',
  templateUrl: './ordem-servico.component.html',
  styleUrls: ['./ordem-servico.component.css']
})
export class OrdemServicoComponent implements OnInit {

  constructor(private orderService : ServiceOrderService) { }
  show: Boolean = false;
  serviceOrder : ServiceOrderVO = {doctorId: null, postId: null,healthInsurance: null, date: '', exams: [], id: null, patientId: null};
  listDoctors: Array<DoctorVO>;
  listPatients: Array<PatientVO>;
  listPosts: Array<CollectionPostVO>;
  listExams: Array<ExamVO>;
  examAdd: number;
  listExamsAdd: Array<ExamVO> = [];
  list: Array<ServiceOrderObjVO> = [];
  ngOnInit(): void {
    this.listOrders();
    this.orderService.get("list_doctors").subscribe((data : Array<DoctorVO>) => this.listDoctors = data);
    this.orderService.get("list_patients").subscribe((data : Array<PatientVO>) => this.listPatients = data);
    this.orderService.get("list_posts").subscribe((data : Array<CollectionPostVO>) => this.listPosts = data);
    this.orderService.get("list_exams").subscribe((data : Array<ExamVO>) => this.listExams = data);
  }


  new(){
    this.serviceOrder = {doctorId: null, postId: null,healthInsurance: null, date: '', exams: [], id: null, patientId: null};
    this.show = true;
  }

  save(ordemServico : ServiceOrderVO){

    let retorno : ServiceOrderObjVO;
    this.orderService.post(ordemServico).subscribe((data: ServiceOrderObjVO) =>  {
      console.log(data);
      this.listExamsAdd = [];
      this.listOrders();
      this.show = false;
    }, err => alert(err.error));

  }

  listOrders(){
    this.orderService.get("list").subscribe((data: Array<ServiceOrderObjVO>) => { this.list = data; console.log(this.list); });
  }

  edit(order: ServiceOrderObjVO){
    this.serviceOrder.id = order.id;
    this.serviceOrder.healthInsurance = order.healthInsurance;
    this.serviceOrder.date = order.date;
    this.listExamsAdd = order.serviceOrderExams.map(o => o.exam);
    this.serviceOrder.doctorId = order.doctor.id;
    this.serviceOrder.patientId = order.patient.id;
    this.serviceOrder.postId = order.collectionPost.id;
    this.show = true;
  }
  delete(ordem: ServiceOrderObjVO){
    console.log(ordem);
    let ordemVO: ServiceOrderVO = {doctorId: null, postId: null,healthInsurance: null, date: '', exams: [], id: null, patientId: null};
    ordemVO.id = ordem.id;
    this.orderService.delete(ordemVO).subscribe((data)=> {
      alert("Excluido com sucesso");
      this.listOrders();

    },(err) => alert(err.message));
  }



  cancel(){
    this.show = false;
  }
}
