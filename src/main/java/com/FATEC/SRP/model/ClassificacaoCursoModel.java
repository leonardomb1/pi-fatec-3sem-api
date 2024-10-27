package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa o modelo de classificação de cursos.
 * Mapeia a tabela "classificacao_cursos" no banco de dados.
 */
@Entity
@Table(name = "classificacao_cursos")
@IdClass(ClassificacaoCursoIdModel.class)
public class ClassificacaoCursoModel {

    /**
     * Identificador da classificação.
     */
    @Id
    private Integer idClassificacao;

    /**
     * Identificador do curso.
     */
    @Id
    private Integer idCurso;

    /**
     * Data de cadastro do registro.
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data de alteração do registro.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor com parâmetros.
     * 
     * @param idClassificacao Identificador da classificação.
     * @param idCurso Identificador do curso.
     */
    public ClassificacaoCursoModel(Integer idClassificacao, Integer idCurso) {
        setIdClassificacao(idClassificacao);
        setIdCurso(idCurso);
    }

    /**
     * Construtor padrão.
     */
    public ClassificacaoCursoModel() {
    }

    /**
     * Obtém o identificador da classificação.
     * 
     * @return Identificador da classificação.
     */
    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    /**
     * Define o identificador da classificação.
     * 
     * @param idClassificacao Identificador da classificação.
     */
    public void setIdClassificacao(Integer idClassificacao) {
        this.idClassificacao = idClassificacao;
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
     * Obtém a data de cadastro do registro.
     * 
     * @return Data de cadastro do registro.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data de alteração do registro.
     * 
     * @return Data de alteração do registro.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
