package com.example.servicos;

import com.example.entity.Exame;
import com.example.repositorio.ExameRepositorio;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExameServico implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 5391072060852135228L;
    /**
     *
     */
    
    @Autowired
    private ExameRepositorio exameRepositorio;

    public List<Exame> Listar(){
        return exameRepositorio.findAll();
    }





}