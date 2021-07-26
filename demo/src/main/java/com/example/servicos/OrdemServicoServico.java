package com.example.servicos;

import com.example.entity.Exame;
import com.example.entity.Medico;
import com.example.entity.OrdemServico;
import com.example.entity.OrdemServicoExame;
import com.example.entity.Paciente;
import com.example.entity.PostoColeta;
import com.example.repositorio.ExameRepositorio;
import com.example.repositorio.MedicoRepositorio;
import com.example.repositorio.OrdemServicoExameRepositorio;
import com.example.repositorio.OrdemServicoRepositorio;
import com.example.repositorio.PacienteRepositorio;
import com.example.repositorio.PostoColetaRepositorio;
import com.example.vo.OrdemServicoVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdemServicoServico implements Serializable  {
    
    /**
     *
     */
    
    /**
     *
     */
    private static final long serialVersionUID = 5108105748535290136L;
    /**
     *
     */
    /**
     *
     */
    
    @Autowired
    private OrdemServicoRepositorio ordemServicoRepositorio;
    @Autowired
    private MedicoRepositorio medicoRepositorio;
    @Autowired
    private PacienteRepositorio pacienteRepositorio;
    @Autowired
    private PostoColetaRepositorio postoColetaRepositorio;
    @Autowired
    private ExameRepositorio exameRepositorio;
    public List<OrdemServico> Listar(){
        return ordemServicoRepositorio.findAll();
    }
    public Boolean Remover(OrdemServicoVO ordem){
        try{
        if(ordem.getId() == null)
            return false;
        OrdemServico ordemServico = ordemServicoRepositorio.getById(ordem.getId());
        
        ordemServicoRepositorio.delete(ordemServico);
        return true;
        }catch(Exception ex){
            return false;
        }
    }

    private OrdemServico BuscarOuCriaInstancia(Integer id){
        if(id == null)
            return new OrdemServico();
        return ordemServicoRepositorio.getById(id);
    }


    private OrdemServico PreencheObjeto(OrdemServicoVO ordemServicoVO, OrdemServico ordemServico){
        List<OrdemServicoExame> listaOrdemExames = new ArrayList<>();
        List<Exame> listaExames = exameRepositorio.findAllById(ordemServicoVO.getExames());
        for(Exame ex : listaExames){

            listaOrdemExames.add(new OrdemServicoExame(ex, ordemServico, ex.getPreco() ));
        }

        PostoColeta posto = postoColetaRepositorio.getById(ordemServicoVO.getPostoId());
        Paciente paciente = pacienteRepositorio.getById(ordemServicoVO.getPacienteId());
        Medico medico = medicoRepositorio.getById(ordemServicoVO.getMedicoId());
        ordemServico.setConvenio(ordemServicoVO.getConvenio());
        ordemServico.setData(ordemServicoVO.getData());
        ordemServico.setPostoColeta(posto);
        ordemServico.setPaciente(paciente);
        ordemServico.setMedico(medico);
        if(ordemServicoVO.getId() != null){
            
            ordemServico.getOrdensExames().clear();
            ordemServico.getOrdensExames().addAll(listaOrdemExames);
        }else{
            ordemServico.setOrdensExames(listaOrdemExames);
        }
        return ordemServico;
       
    }

    private String ValidarDados(OrdemServicoVO ordemServicoVO){
        if(ordemServicoVO.getMedicoId() == null)
            return "Médico inválido";
        if(ordemServicoVO.getPacienteId() == null)
            return "Paciente inválido";
        if(ordemServicoVO.getPostoId() == null)
            return "Posto de coleta inválido";
        return null;
    }

    public OrdemServico Salvar(OrdemServicoVO ordemServicoVO) throws Exception {
        if(ordemServicoVO == null)
            return null;

        String validacaoMsg = this.ValidarDados(ordemServicoVO);
        if(validacaoMsg != null)
            throw new Exception(validacaoMsg);
        
        OrdemServico ordemServico = this.BuscarOuCriaInstancia(ordemServicoVO.getId());

        ordemServico = this.PreencheObjeto(ordemServicoVO, ordemServico);
        
        ordemServicoRepositorio.save(ordemServico);   
        return ordemServico;
    }





}