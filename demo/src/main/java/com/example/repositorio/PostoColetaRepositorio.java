package com.example.repositorio;

import com.example.entity.PostoColeta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostoColetaRepositorio extends JpaRepository<PostoColeta, Integer> {
    
}