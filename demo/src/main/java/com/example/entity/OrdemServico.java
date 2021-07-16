package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.FetchType;

@Entity(name="ordemServico")
@Table(name = "ordemServicos")
public class OrdemServico implements  Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -8376730849350729963L;

    public OrdemServico() {
    }
    public OrdemServico( Date data, Paciente paciente, Medico medico, PostoColeta postoColeta, String convenio) {
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.postoColeta = postoColeta;
        this.convenio = convenio;
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
    private Date data;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="medico_id")
    private Medico medico;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="posto_id")
    private PostoColeta postoColeta;
    @Column(length=100, nullable=false)
    private String convenio;
    @OneToMany(mappedBy="ordemServico", fetch= FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrdemServicoExame> ordensExames; 

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public PostoColeta getPostoColeta() {
        return postoColeta;
    }

    public void setPostoColeta(PostoColeta postoColeta) {
        this.postoColeta = postoColeta;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public List<OrdemServicoExame> getOrdensExames() {
        return ordensExames;
    }

    public void setOrdensExames(List<OrdemServicoExame> ordensExames) {
        this.ordensExames = ordensExames;
    }

   

    

    

      


}