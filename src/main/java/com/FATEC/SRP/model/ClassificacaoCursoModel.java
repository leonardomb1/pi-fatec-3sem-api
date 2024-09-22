package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "classificacao_cursos")
@IdClass(ClassificacaoCursoIdModel.class)
public class ClassificacaoCursoModel {

    @Id
    private Integer idClassificacao;

    @Id
    private Integer idCurso;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
    

    public ClassificacaoCursoModel(Integer idClassificacao, Integer idCurso) {
        setIdClassificacao(idClassificacao);
        setIdCurso(idCurso);
    }

    public ClassificacaoCursoModel() {
    }

    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Integer idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }
    
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
