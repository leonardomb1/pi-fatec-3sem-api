package com.FATEC.SRP.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Modelo de ID de Pré-Requisito que implementa Serializable.
 * Representa a chave composta para a entidade de pré-requisito.
 */
public class PreRequisitoIdModel implements Serializable {
    /**
     * ID do curso.
     */
    private Integer idCurso;

    /**
     * ID do pré-requisito.
     */
    private Integer idPreRequisito;

    /**
     * Compara este objeto com o objeto especificado para igualdade.
     * 
     * @param o o objeto a ser comparado para igualdade
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreRequisitoIdModel)) return false;
        PreRequisitoIdModel that = (PreRequisitoIdModel) o;
        return Objects.equals(idCurso, that.idCurso) &&
               Objects.equals(idPreRequisito, that.idPreRequisito);
    }

    /**
     * Retorna um código hash para este objeto.
     * 
     * @return um valor de código hash para este objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idPreRequisito);
    }

    /**
     * Construtor que inicializa o modelo com os IDs do curso e do pré-requisito.
     * 
     * @param idCurso o ID do curso
     * @param idPreRequisito o ID do pré-requisito
     */
    public PreRequisitoIdModel(Integer idCurso, Integer idPreRequisito) {
        setIdCurso(idCurso);
        setIdPreRequisito(idPreRequisito);
    }

    /**
     * Construtor padrão.
     */
    public PreRequisitoIdModel() {
    }

    /**
     * Retorna o ID do curso.
     * 
     * @return o ID do curso
     */
    public Integer getIdCurso() {
        return idCurso;
    }

    /**
     * Define o ID do curso.
     * 
     * @param idCurso o ID do curso a ser definido
     */
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Retorna o ID do pré-requisito.
     * 
     * @return o ID do pré-requisito
     */
    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    /**
     * Define o ID do pré-requisito.
     * 
     * @param idPreRequisito o ID do pré-requisito a ser definido
     */
    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }
}
