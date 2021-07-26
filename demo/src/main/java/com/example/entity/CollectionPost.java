package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="collectionPost")
@Table(name = "collectionPost")
public class CollectionPost implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1513431052981971637L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=100, nullable=false)
    private String description;
    @Column(length=100, nullable=false)
    private String address;

    public CollectionPost() {
    }

    public CollectionPost( String description, String address) {
        this.description = description;
        this.address = address;
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

    public void setDescription(String descricao) {
        this.description = descricao;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String endereco) {
        this.address = endereco;
    }


}