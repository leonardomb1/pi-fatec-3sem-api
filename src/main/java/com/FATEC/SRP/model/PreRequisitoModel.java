package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa o modelo de pré-requisitos de um curso.
 * Esta classe é mapeada para a tabela "pre_requisitos" no banco de dados.
 * Utiliza a classe PreRequisitoIdModel como chave composta.
 */
@Entity
@Table(name = "pre_requisitos")
@IdClass(PreRequisitoIdModel.class)
public class PreRequisitoModel {

    /**
     * Identificador do curso.
     */
    @Id
    private Integer idCurso;

    /**
     * Identificador do pré-requisito.
     */
    @Id
    private Integer idPreRequisito;

    /**
     * Data de cadastro do pré-requisito.
     * Este campo não pode ser atualizado.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data de alteração do pré-requisito.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor com parâmetros.
     * 
     * @param idCurso Identificador do curso.
     * @param idPreRequisito Identificador do pré-requisito.
     */
    public PreRequisitoModel(Integer idCurso, Integer idPreRequisito) {
        setIdCurso(idCurso);
        setIdPreRequisito(idPreRequisito);
    }

    /**
     * Construtor padrão.
     */
    public PreRequisitoModel() {
    }

    /**
     * Obtém o identificador do curso.
     * 
     * @return Identificador do curso.
     */
    public Integer getIdCurso() {
        return idCurso;
    }

    /**
     * Define o identificador do curso.
     * 
     * @param idCurso Identificador do curso.
     */
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Obtém o identificador do pré-requisito.
     * 
     * @return Identificador do pré-requisito.
     */
    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    /**
     * Define o identificador do pré-requisito.
     * 
     * @param idPreRequisito Identificador do pré-requisito.
     */
    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }

    /**
     * Obtém a data de cadastro do pré-requisito.
     * 
     * @return Data de cadastro do pré-requisito.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }
    
    /**
     * Obtém a data de alteração do pré-requisito.
     * 
     * @return Data de alteração do pré-requisito.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
