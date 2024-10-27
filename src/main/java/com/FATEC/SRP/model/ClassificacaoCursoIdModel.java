package com.FATEC.SRP.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Modelo que representa a chave composta para a classificação de um curso.
 * Implementa Serializable para permitir que a chave seja utilizada em operações de persistência.
 */
public class ClassificacaoCursoIdModel implements Serializable {

    /**
     * Identificador da classificação.
     */
    private Integer idClassificacao;

    /**
     * Identificador do curso.
     */
    private Integer idCurso;

    /**
     * Construtor padrão.
     */
    public ClassificacaoCursoIdModel() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param idClassificacao o identificador da classificação
     * @param idCurso o identificador do curso
     */
    public ClassificacaoCursoIdModel(Integer idClassificacao, Integer idCurso) {
        setIdClassificacao(idClassificacao);
        setIdCurso(idCurso);
    }

    /**
     * Obtém o identificador da classificação.
     *
     * @return o identificador da classificação
     */
    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    /**
     * Define o identificador da classificação.
     *
     * @param idClassificacao o identificador da classificação
     */
    public void setIdClassificacao(Integer idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    /**
     * Obtém o identificador do curso.
     *
     * @return o identificador do curso
     */
    public Integer getIdCurso() {
        return idCurso;
    }

    /**
     * Define o identificador do curso.
     *
     * @param idCurso o identificador do curso
     */
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    /**
     * Verifica se este objeto é igual a outro objeto.
     *
     * @param o o objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificacaoCursoIdModel)) return false;
        ClassificacaoCursoIdModel that = (ClassificacaoCursoIdModel) o;
        return Objects.equals(idClassificacao, that.idClassificacao) &&
               Objects.equals(idCurso, that.idCurso);
    }

    /**
     * Calcula o código hash para este objeto.
     *
     * @return o código hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(idClassificacao, idCurso);
    }
}
