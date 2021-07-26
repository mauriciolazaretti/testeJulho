package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="doctor")
@Table(name = "doctors")
public class Doctor implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 2216760071166445350L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=100, nullable=false)
    private String name;
    @Column(length=100, nullable=false)
    private String specialty;

    public Doctor() {
    }

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

   


}