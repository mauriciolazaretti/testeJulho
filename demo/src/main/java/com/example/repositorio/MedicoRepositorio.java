package com.example.repositorio;

import com.example.entity.Medico;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
    
}