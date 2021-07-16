package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "pacientes")
@Table(name =  "pacientes")
public class Paciente implements Serializable  {
    
    public Paciente(){

    }
    public Paciente(String nome, String sexo, String endereco, Date dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }
    
    /**
     *
     */
    private static final long serialVersionUID = 5929087968903561941L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 20, nullable = false)
    private String sexo;
    @Column(length = 100, nullable = false)
    private String endereco;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    



}