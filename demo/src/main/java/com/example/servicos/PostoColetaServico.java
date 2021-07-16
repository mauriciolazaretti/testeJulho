package com.example.servicos;

import com.example.entity.PostoColeta;
import com.example.repositorio.PostoColetaRepositorio;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostoColetaServico implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4368110773439986774L;
    /**
     *
     */
    @Autowired
    private PostoColetaRepositorio postoColetaRepositorio;

    public List<PostoColeta> Listar(){
        return postoColetaRepositorio.findAll();
    }





}