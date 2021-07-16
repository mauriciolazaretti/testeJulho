package com.example.servicos;

import com.example.entity.Paciente;
import com.example.repositorio.PacienteRepositorio;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PacienteServico implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 5420397343479861154L;
    /**
     *
     */
    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    public List<Paciente> Listar(){
        return pacienteRepositorio.findAll();
    }





}