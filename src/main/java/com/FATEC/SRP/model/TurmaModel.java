package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa o modelo de uma Turma.
 */
@Entity
@Table(name = "turmas")
public class TurmaModel {

    /**
     * Identificador único da turma.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    /**
     * Identificador do curso ao qual a turma pertence.
     */
    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    /**
     * Data de início da turma.
     */
    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    /**
     * Data de término da turma.
     */
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    /**
     * Período da turma (ex: manhã, tarde, noite).
     */
    @Column(name = "periodo", nullable = false)
    private String periodo;

    /**
     * Data de cadastro da turma.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração da turma.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor da classe TurmaModel.
     * 
     * @param idCurso Identificador do curso.
     * @param dataInicio Data de início da turma.
     * @param periodo Período da turma.
     */
    public TurmaModel(Integer idCurso, Date dataInicio, String periodo) {
        setIdCurso(idCurso);
        setDataInicio(dataInicio);
        setPeriodo(periodo);
    }

    /**
     * Construtor da classe TurmaModel.
     * 
     * @param idCurso Identificador do curso.
     * @param dataInicio Data de início da turma.
     * @param dataFim Data de término da turma.
     * @param periodo Período da turma.
     */
    public TurmaModel(Integer idCurso, Date dataInicio, Date dataFim, String periodo) {
        setIdCurso(idCurso);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setPeriodo(periodo);
    }

    /**
     * Obtém o identificador da turma.
     * 
     * @return Identificador da turma.
     */
    public Integer getIdTurma() {
        return idTurma;
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
     * Obtém a data de início da turma.
     * 
     * @return Data de início da turma.
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * Define a data de início da turma.
     * 
     * @param dataInicio Data de início da turma.
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Obtém a data de término da turma.
     * 
     * @return Data de término da turma.
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * Define a data de término da turma.
     * 
     * @param dataFim Data de término da turma.
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * Obtém o período da turma.
     * 
     * @return Período da turma.
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Define o período da turma.
     * 
     * @param periodo Período da turma.
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * Obtém a data de cadastro da turma.
     * 
     * @return Data de cadastro da turma.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Define a data de cadastro da turma.
     * 
     * @param dtCadastro Data de cadastro da turma.
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * Obtém a data da última alteração da turma.
     * 
     * @return Data da última alteração da turma.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    /**
     * Define a data da última alteração da turma.
     * 
     * @param dtAlteracao Data da última alteração da turma.
     */
    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
}
