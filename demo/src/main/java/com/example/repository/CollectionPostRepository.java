package com.example.repository;

import com.example.entity.CollectionPost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionPostRepository extends JpaRepository<CollectionPost, Integer> {
    
}