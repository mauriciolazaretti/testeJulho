package com.example.services;

import com.example.entity.CollectionPost;
import com.example.repository.CollectionPostRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CollectionPostService implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4368110773439986774L;
    /**
     *
     */
    @Autowired
    private CollectionPostRepository collectionPostRepository;

    public List<CollectionPost> List(){
        return collectionPostRepository.findAll();
    }





}