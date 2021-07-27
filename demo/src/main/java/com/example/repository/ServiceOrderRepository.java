package com.example.repository;

import com.example.entity.ServiceOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {
    
}