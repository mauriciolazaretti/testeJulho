import { DoctorVO } from "./doctor-vo";
import { PatientVO } from "./patient-vo";
import { CollectionPostVO } from "./collection-post-vo";
import { ServiceExamVO } from "./service-exam-vo";

export interface ServiceOrderObjVO {
  id: number;
  date: string;
  patient: PatientVO;
  doctor: DoctorVO;
  collectionPost: CollectionPostVO;
  healthInsurance: string;
  serviceOrderExams: Array<ServiceExamVO>
}
