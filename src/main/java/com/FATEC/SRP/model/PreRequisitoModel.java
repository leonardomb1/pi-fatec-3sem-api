package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pre_requisitos")
@IdClass(PreRequisitoIdModel.class)
public class PreRequisitoModel {

    @Id
    private Integer idCurso;

    @Id
    private Integer idPreRequisito;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    public PreRequisitoModel(Integer idCurso, Integer idPreRequisito) {
        setIdCurso(idCurso);
        setIdPreRequisito(idPreRequisito);
    }

    public PreRequisitoModel() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }
    
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
