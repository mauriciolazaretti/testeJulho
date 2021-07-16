package com.example.servicos;

import com.example.entity.Medico;
import com.example.repositorio.MedicoRepositorio;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicoServico implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 7916021919826780813L;
    /**
     *
     */
    
    @Autowired
    private MedicoRepositorio medicoRepositorio;

    public List<Medico> Listar(){
        return medicoRepositorio.findAll();
    }





}