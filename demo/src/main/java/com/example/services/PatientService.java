package com.example.services;

import com.example.entity.Patient;
import com.example.repository.PatientRepository;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 5420397343479861154L;
    /**
     *
     */
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> List(){
        return patientRepository.findAll();
    }





}