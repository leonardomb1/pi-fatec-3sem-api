package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa um modelo de curso.
 */
@Entity
@Table(name = "cursos")
public class CursoModel {

    /**
     * Identificador único do curso.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    /**
     * Nome do curso.
     */
    @Column(name = "nome_curso", nullable = false)
    private String nomeCurso;

    /**
     * Descrição do curso.
     */
    @Column(name = "desc_curso")
    private String descCurso;

    /**
     * Programação do curso.
     */
    @Column(name = "programacao")
    private String programacao;

    /**
     * Data de cadastro do curso.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração do curso.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor com nome, descrição e programação do curso.
     * 
     * @param nomeCurso Nome do curso.
     * @param descCurso Descrição do curso.
     * @param programacao Programação do curso.
     */
    public CursoModel(String nomeCurso, String descCurso, String programacao) {
        setNomeCurso(nomeCurso);
        setDescCurso(descCurso);
        setProgramacao(programacao);
    }

    /**
     * Construtor com nome do curso.
     * 
     * @param nomeCurso Nome do curso.
     */
    public CursoModel(String nomeCurso) {
        setNomeCurso(nomeCurso);
    }

    /**
     * Construtor padrão.
     */
    public CursoModel() {
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
     * Obtém o nome do curso.
     * 
     * @return Nome do curso.
     */
    public String getNomeCurso() {
        return nomeCurso;
    }

    /**
     * Define o nome do curso.
     * 
     * @param nomeCurso Nome do curso.
     */
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    /**
     * Obtém a descrição do curso.
     * 
     * @return Descrição do curso.
     */
    public String getDescCurso() {
        return descCurso;
    }

    /**
     * Define a descrição do curso.
     * 
     * @param descCurso Descrição do curso.
     */
    public void setDescCurso(String descCurso) {
        this.descCurso = descCurso;
    }

    /**
     * Obtém a programação do curso.
     * 
     * @return Programação do curso.
     */
    public String getProgramacao() {
        return programacao;
    }

    /**
     * Define a programação do curso.
     * 
     * @param programacao Programação do curso.
     */
    public void setProgramacao(String programacao) {
        this.programacao = programacao;
    }

    /**
     * Obtém a data de cadastro do curso.
     * 
     * @return Data de cadastro do curso.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração do curso.
     * 
     * @return Data da última alteração do curso.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }  
}
