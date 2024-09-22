package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "classificacao")
public class ClassificacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassificacao;

    @Column(name = "nome_classificacao", nullable = false)
    private String nomeClassificacao;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
    

    public ClassificacaoModel(String nomeClassificacao) {
        setNomeClassificacao(nomeClassificacao);
    }

    public ClassificacaoModel() {
    }

    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    public String getNomeClassificacao() {
        return nomeClassificacao;
    }

    public void setNomeClassificacao(String nomeClassificacao) {
        this.nomeClassificacao = nomeClassificacao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
