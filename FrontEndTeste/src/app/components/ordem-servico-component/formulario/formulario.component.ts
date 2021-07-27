import { Input, Output } from '@angular/core';
import { Component, OnInit,EventEmitter } from '@angular/core';
import { ExamVO } from 'src/app/interfaces/exam-vo';
import { DoctorVO } from 'src/app/interfaces/doctor-vo';
import { ServiceOrderVO } from 'src/app/interfaces/service-order-vo';
import { PatientVO } from 'src/app/interfaces/patient-vo';
import { CollectionPostVO } from 'src/app/interfaces/collection-post-vo';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  @Input()
  serviceOrder : ServiceOrderVO;
  @Input()
  listDoctors: Array<DoctorVO>;
  @Input()
  listPatients: Array<PatientVO>;
  @Input()
  listPosts: Array<CollectionPostVO>;
  @Input()
  listExams: Array<ExamVO>;
  examAdd: number;
  @Input()
  listExamsAdd: Array<ExamVO> = [];

  @Output() eventoSalvar = new EventEmitter<ServiceOrderVO>();
  @Output() eventoCancelar = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }
  addExam(){
    console.log(this.examAdd);
    let exame: ExamVO = this.listExams.find(o => o.id == this.examAdd);
    this.listExamsAdd.push(exame);
  }
  removeExam(exame: ExamVO){
    console.log(this.listExamsAdd);
    this.listExamsAdd.splice(this.listExamsAdd.indexOf(exame),1);
    console.log(this.listExamsAdd);
  }

  save(){
    this.serviceOrder.exams = this.listExamsAdd.map(o => o.id);
    this.eventoSalvar.emit(this.serviceOrder);
  }

  cancel(){
    this.eventoCancelar.emit();
  }
}
