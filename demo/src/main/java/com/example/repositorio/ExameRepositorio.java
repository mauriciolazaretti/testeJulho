package com.example.repositorio;

import com.example.entity.Exame;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepositorio extends JpaRepository<Exame, Integer> {
    
}