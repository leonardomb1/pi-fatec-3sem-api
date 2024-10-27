package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Representa um modelo de Cargo.
 */
@Entity
@Table(name = "cargos")
public class CargoModel {

    /**
     * Identificador único do cargo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    /**
     * Nome do cargo.
     */
    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;

    /**
     * Nível de permissão do cargo.
     */
    @Column(name = "nivel_permissao", nullable = false)
    private Integer nivelPermissao;

    /**
     * Data de cadastro do cargo.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração do cargo.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor padrão.
     */
    public CargoModel() {
    }

    /**
     * Construtor com parâmetros.
     * 
     * @param nomeCargo Nome do cargo.
     * @param nivelPermissao Nível de permissão do cargo.
     */
    public CargoModel(String nomeCargo, Integer nivelPermissao) {
        setNomeCargo(nomeCargo);
        setNivelPermissao(nivelPermissao);
    }

    /**
     * Obtém o identificador do cargo.
     * 
     * @return Identificador do cargo.
     */
    public Integer getIdCargo() {
        return idCargo;
    }

    /**
     * Obtém o nome do cargo.
     * 
     * @return Nome do cargo.
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * Define o nome do cargo.
     * 
     * @param nomeCargo Nome do cargo.
     */
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    /**
     * Obtém o nível de permissão do cargo.
     * 
     * @return Nível de permissão do cargo.
     */
    public Integer getNivelPermissao() {
        return nivelPermissao;
    }

    /**
     * Define o nível de permissão do cargo.
     * 
     * @param nivelPermissao Nível de permissão do cargo.
     */
    public void setNivelPermissao(Integer nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    /**
     * Obtém a data de cadastro do cargo.
     * 
     * @return Data de cadastro do cargo.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração do cargo.
     * 
     * @return Data da última alteração do cargo.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }    
}
