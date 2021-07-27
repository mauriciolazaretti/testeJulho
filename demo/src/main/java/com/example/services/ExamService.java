package com.example.services;

import com.example.entity.Exam;
import com.example.repository.ExamRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamService implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 5391072060852135228L;
    /**
     *
     */
    
    @Autowired
    private ExamRepository examRepository;

    public List<Exam> List(){
        return examRepository.findAll();
    }





}