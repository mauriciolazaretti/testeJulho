import { MedicoVO } from "./medico-vo";
import { PacienteVO } from "./paciente-vo";
import { PostoVO } from "./posto-vo";
import { ServicoExameVO } from "./servico-exame-vo";

export interface OrdemServicoObjVO {
  id: number;
  data: string;
  paciente: PacienteVO;
  medico: MedicoVO;
  postoColeta: PostoVO;
  convenio: string;
  ordensExames: Array<ServicoExameVO>
}
