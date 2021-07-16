package com.example.repositorio;

import com.example.entity.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Integer> {
    
}