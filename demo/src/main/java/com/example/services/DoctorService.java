package com.example.services;

import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorService implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 7916021919826780813L;
    /**
     *
     */
    
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> List(){
        return doctorRepository.findAll();
    }





}