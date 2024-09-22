package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trilhas")
public class TrilhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrilha;

    @Column(name = "nome_trilha", nullable = false)
    private String nomeTrilha;

    @Column(name = "desc_trilha")
    private String descTrilha;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    public TrilhaModel(String nomeTrilha) {
        setNomeTrilha(nomeTrilha);
    }

    public TrilhaModel(String nomeTrilha, String descTrilha) {
        setNomeTrilha(nomeTrilha);
        setDescTrilha(descTrilha);
    }

    public TrilhaModel() {
    }

    public Integer getIdTrilha() {
        return idTrilha;
    }

    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    public String getDescTrilha() {
        return descTrilha;
    }

    public void setDescTrilha(String descTrilha) {
        this.descTrilha = descTrilha;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    
}
