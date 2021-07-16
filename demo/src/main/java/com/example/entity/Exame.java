package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="exame")
@Table(name = "exames")
public class Exame implements  Serializable{

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
    private String descricao;
    private Double preco;

    @OneToMany(mappedBy="exame")
    @JsonIgnore
    private List<OrdemServicoExame> ordensExames; 

    public Exame(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
        
    }

    public Exame() {
    }
    

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<OrdemServicoExame> getOrdensExames() {
        return ordensExames;
    }

    public void setOrdensExames(List<OrdemServicoExame> ordensExames) {
        this.ordensExames = ordensExames;
    }

      


}