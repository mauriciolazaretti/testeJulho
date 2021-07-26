package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="serviceOrderExam")
@Table(name = "serviceOrderExam")
public class ServiceOrderExam implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 4291936327306433871L;

    /**
     *
     */
    

    public ServiceOrderExam() {
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
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="exam_id")
    private Exam exam;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="service_order_id")
    @JsonIgnore
    private ServiceOrder serviceOrder;
    private Double price;

    public ServiceOrderExam(Exam exam, ServiceOrder serviceOrder, Double price) {
        this.exam = exam;
        this.serviceOrder = serviceOrder;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    

   

   

    

    

      


}