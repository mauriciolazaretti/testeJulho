package com.example.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ServiceOrderVO implements Serializable {
    /**ServiceOrderVO
     *
     */
    private static final long serialVersionUID = 9010811575053718837L;
    /**
     *ServiceOrderVO
     */
    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Integer patientId;
    private Integer doctorId;
    private Integer postId;
    private String healthInsurance;
    private List<Integer> exams; 
    private Double price;

    public ServiceOrderVO() {
    }

    public ServiceOrderVO(Date date, Integer patientId, Integer doctorId, Integer postId, String healthInsurance, List<Integer> exams) {
        this.date = date;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.postId = postId;
        this.healthInsurance = healthInsurance;
        this.exams = exams;
    }
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

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public List<Integer> getExams() {
        return exams;
    }

    public void setExams(List<Integer> exams) {
        this.exams = exams;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    


}