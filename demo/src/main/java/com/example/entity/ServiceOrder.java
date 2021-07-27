package com.example.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="serviceOrder")
@Table(name = "serviceOrder")
public class ServiceOrder implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -8376730849350729963L;

    public ServiceOrder() {
    }
    public ServiceOrder( Date date, Patient patient, Doctor doctor, CollectionPost collectionPost, String healthInsurance) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.collectionPost = collectionPost;
        this.healthInsurance = healthInsurance;
    }
    /**
     *
     */
    /**
     *
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="post_id")
    private CollectionPost collectionPost;
    @Column(length=100, nullable=false)
    private String healthInsurance;
    @OneToMany(mappedBy="serviceOrder", fetch= FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ServiceOrderExam> serviceOrderExams; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public CollectionPost getCollectionPost() {
        return collectionPost;
    }

    public void setCollectionPost(CollectionPost collectionPost) {
        this.collectionPost = collectionPost;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public List<ServiceOrderExam> getServiceOrderExams() {
        return serviceOrderExams;
    }

    public void setServiceOrderExams(List<ServiceOrderExam> serviceOrderExams) {
        this.serviceOrderExams = serviceOrderExams;
    }

    

   

    

    

      


}