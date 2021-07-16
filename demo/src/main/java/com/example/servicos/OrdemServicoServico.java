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
    @Autowired
    private OrdemServicoExameRepositorio servicoExameRepositorio;
    public List<OrdemServico> Listar(){
        return ordemServicoRepositorio.findAll();
    }
    public Boolean Remover(OrdemServicoVO ordem){
        try{
        if(ordem.getId() == null)
            return false;
        OrdemServico ordemServico = ordemServicoRepositorio.getById(ordem.getId());
        
        servicoExameRepositorio.deleteAllInBatch(ordemServico.getOrdensExames());
        ordemServicoRepositorio.delete(ordemServico);
        return true;
        }catch(Exception ex){
            return false;
        }
    }
    public OrdemServico Salvar(OrdemServicoVO ordemServicoVO) throws Exception{
        if(ordemServicoVO == null)
            return null;

        if(ordemServicoVO.getMedicoId() == null)
            throw new Exception("Medico inválido");
        if(ordemServicoVO.getPacienteId() == null)
            throw new Exception("Paciente inválido");
        if(ordemServicoVO.getPostoId() == null)
            throw new Exception("Posto de coleta inválido");
        PostoColeta posto = postoColetaRepositorio.getById(ordemServicoVO.getPostoId());
        Paciente paciente = pacienteRepositorio.getById(ordemServicoVO.getPacienteId());
        Medico medico = medicoRepositorio.getById(ordemServicoVO.getMedicoId());

        
        OrdemServico ordemServico = ordemServicoVO.getId() != null ? ordemServicoRepositorio.getById(ordemServicoVO.getId()) : new OrdemServico(ordemServicoVO.getData(), paciente, medico, posto, ordemServicoVO.getConvenio());
        
        

        List<OrdemServicoExame> listaOrdemExames = new ArrayList<>();
        
        List<Exame> listaExames = exameRepositorio.findAllById(ordemServicoVO.getExames());
        for(Exame ex : listaExames){

            listaOrdemExames.add(new OrdemServicoExame(ex, ordemServico, ex.getPreco() ));
        }
        if(ordemServicoVO.getId() != null){
            ordemServico.setConvenio(ordemServicoVO.getConvenio());
            ordemServico.setData(ordemServicoVO.getData());
            ordemServico.setPostoColeta(posto);
            ordemServico.setPaciente(paciente);
            ordemServico.setMedico(medico);
            ordemServico.getOrdensExames().clear();
            ordemServico.getOrdensExames().addAll(listaOrdemExames);
        }else{
            ordemServico.setOrdensExames(listaOrdemExames);
        }
        ordemServicoRepositorio.save(ordemServico);   
        return ordemServico;
    }





}