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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="ordemServicoExame")
@Table(name = "ordemServicoExames")
public class OrdemServicoExame implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 4291936327306433871L;

    /**
     *
     */
    

    public OrdemServicoExame() {
    }
    
    public OrdemServicoExame( Exame exame, OrdemServico ordemServico, Double preco) {
        this.exame = exame;
        this.ordemServico = ordemServico;
        this.preco = preco;
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
    @JoinColumn(name="exame_id")
    private Exame exame;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ordem_servico_id")
    @JsonIgnore
    private OrdemServico ordemServico;
    private Double preco;

    

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


   

    

    

      


}