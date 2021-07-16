package com.example.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdemServicoVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 9010811575053718837L;
    /**
     *
     */
    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date data;
    private Integer pacienteId;
    private Integer medicoId;
    private Integer postoId;
    private String convenio;
    private List<Integer> exames; 
    private Double preco;

    public OrdemServicoVO() {
    }

    public OrdemServicoVO(Date data, Integer pacienteId, Integer medicoId, Integer postoId, String convenio, List<Integer> exames) {
        this.data = data;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.postoId = postoId;
        this.convenio = convenio;
        this.exames = exames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

    public Integer getPostoId() {
        return postoId;
    }

    public void setPostoId(Integer postoId) {
        this.postoId = postoId;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public List<Integer> getExames() {
        return exames;
    }

    public void setExames(List<Integer> exames) {
        this.exames = exames;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


}