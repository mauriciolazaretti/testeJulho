package com.example.repositorio;

import com.example.entity.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    
}
