package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="exam")
@Table(name = "exams")
public class Exam implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -308785852782843323L;
    /**
     *
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=100, nullable=false)
    private String description;
    private Double price;

    @OneToMany(mappedBy="exam")
    @JsonIgnore
    private List<ServiceOrderExam> serviceOrderExams; 

    public Exam(String descricao, Double preco) {
        this.description = descricao;
        this.price = preco;
        
    }

    public Exam() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ServiceOrderExam> getServiceOrderExams() {
        return serviceOrderExams;
    }

    public void setServiceOrderExams(List<ServiceOrderExam> serviceOrderExams) {
        this.serviceOrderExams = serviceOrderExams;
    }

    
    

    
   

      


}