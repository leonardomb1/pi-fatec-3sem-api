package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cargos")
public class CargoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;

    @Column(name = "nivel_permissao", nullable = false)
    private Integer nivelPermissao;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    public CargoModel() {
    }

    public CargoModel(String nomeCargo, Integer nivelPermissao) {
        setNomeCargo(nomeCargo);
        setNivelPermissao(nivelPermissao);
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Integer getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(Integer nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }    
}
