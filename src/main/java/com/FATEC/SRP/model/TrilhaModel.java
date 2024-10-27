package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa o modelo de uma trilha.
 */
@Entity
@Table(name = "trilhas")
public class TrilhaModel {

    /**
     * Identificador único da trilha.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrilha;

    /**
     * Nome da trilha.
     */
    @Column(name = "nome_trilha", nullable = false)
    private String nomeTrilha;

    /**
     * Descrição da trilha.
     */
    @Column(name = "desc_trilha")
    private String descTrilha;

    /**
     * Data de cadastro da trilha.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração da trilha.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor que inicializa a trilha com o nome fornecido.
     * 
     * @param nomeTrilha Nome da trilha.
     */
    public TrilhaModel(String nomeTrilha) {
        setNomeTrilha(nomeTrilha);
    }

    /**
     * Construtor que inicializa a trilha com o nome e a descrição fornecidos.
     * 
     * @param nomeTrilha Nome da trilha.
     * @param descTrilha Descrição da trilha.
     */
    public TrilhaModel(String nomeTrilha, String descTrilha) {
        setNomeTrilha(nomeTrilha);
        setDescTrilha(descTrilha);
    }

    /**
     * Construtor padrão.
     */
    public TrilhaModel() {
    }

    /**
     * Obtém o identificador da trilha.
     * 
     * @return Identificador da trilha.
     */
    public Integer getIdTrilha() {
        return idTrilha;
    }

    /**
     * Obtém o nome da trilha.
     * 
     * @return Nome da trilha.
     */
    public String getNomeTrilha() {
        return nomeTrilha;
    }

    /**
     * Define o nome da trilha.
     * 
     * @param nomeTrilha Nome da trilha.
     */
    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    /**
     * Obtém a descrição da trilha.
     * 
     * @return Descrição da trilha.
     */
    public String getDescTrilha() {
        return descTrilha;
    }

    /**
     * Define a descrição da trilha.
     * 
     * @param descTrilha Descrição da trilha.
     */
    public void setDescTrilha(String descTrilha) {
        this.descTrilha = descTrilha;
    }

    /**
     * Obtém a data de cadastro da trilha.
     * 
     * @return Data de cadastro da trilha.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Define a data de cadastro da trilha.
     * 
     * @param dtCadastro Data de cadastro da trilha.
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * Obtém a data da última alteração da trilha.
     * 
     * @return Data da última alteração da trilha.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    /**
     * Define a data da última alteração da trilha.
     * 
     * @param dtAlteracao Data da última alteração da trilha.
     */
    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
}
