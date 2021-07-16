package com.example.repositorio;

import com.example.entity.OrdemServicoExame;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemServicoExameRepositorio extends JpaRepository<OrdemServicoExame, Integer> {
    
}