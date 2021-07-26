export interface ServiceOrderVO {
  id: number;
  doctorId:number;
  postId: number;
  patientId: number;
  healthInsurance: string;
  date: string;
  exams: Array<number>

}
