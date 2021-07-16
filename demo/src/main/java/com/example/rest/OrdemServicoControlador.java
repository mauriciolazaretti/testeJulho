package com.example.rest;


import com.example.entity.OrdemServico;
import com.example.servicos.ExameServico;
import com.example.servicos.MedicoServico;
import com.example.servicos.OrdemServicoServico;
import com.example.servicos.PacienteServico;
import com.example.servicos.PostoColetaServico;
import com.example.vo.OrdemServicoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ordemServico")
@CrossOrigin(origins="*")
public class OrdemServicoControlador {
    @Autowired
    private OrdemServicoServico ordemServicoServico;
    @Autowired
    private MedicoServico medicoServico;
    @Autowired
    private PostoColetaServico postoServico;
    @Autowired
    private PacienteServico pacienteServico;
    @Autowired
    private ExameServico exameServico;

    @PostMapping("/deletar")
    ResponseEntity deletar(@RequestBody OrdemServicoVO ordemServicoVO){
        try{
            ordemServicoServico.Remover(ordemServicoVO);
            return new ResponseEntity("", HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    ResponseEntity listar(){
        return new ResponseEntity(ordemServicoServico.Listar(), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    ResponseEntity salvar(@RequestBody OrdemServicoVO ordemServicoVO){
        try{
        OrdemServico ordem = ordemServicoServico.Salvar(ordemServicoVO);
        return new ResponseEntity(ordem, HttpStatus.CREATED);
        }catch(Exception ex){
            return new  ResponseEntity(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar_medicos")
    ResponseEntity listarMedicos(){
        return new ResponseEntity(medicoServico.Listar(), HttpStatus.OK);
    }

    @GetMapping("/listar_pacientes")
    ResponseEntity listarPaciente(){
        return new ResponseEntity(pacienteServico.Listar(), HttpStatus.OK);
    }

    @GetMapping("/listar_postos")
    ResponseEntity listarPostos(){
        return new ResponseEntity(postoServico.Listar(), HttpStatus.OK);
    }

    @GetMapping("/listar_exames")
    ResponseEntity listarExames(){
        return new ResponseEntity(exameServico.Listar(), HttpStatus.OK);
    }
}
