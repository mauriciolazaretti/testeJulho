import { ExameVO } from "./exame-vo";
import { OrdemServicoObjVO } from "./ordem-servico-obj-vo";

export class ServicoExameVO {
  id: number;
  exame: ExameVO;
  ordemServico: OrdemServicoObjVO;
}
