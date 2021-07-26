import { ExameVO } from "./exame-vo";
import { OrdemServicoObjVO } from "./ordem-servico-obj-vo";

export interface ServicoExameVO {
  id: number;
  exame: ExameVO;
  ordemServico: OrdemServicoObjVO;
}
