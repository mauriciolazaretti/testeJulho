import { ExamVO } from "./exam-vo";
import { ServiceOrderObjVO } from "./service-order-obj-vo";

export interface ServiceExamVO {
  id: number;
  exam: ExamVO;
  serviceOrder: ServiceOrderObjVO;
}
