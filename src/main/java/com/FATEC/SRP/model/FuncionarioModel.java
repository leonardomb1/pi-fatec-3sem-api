package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa o modelo de um Funcionário.
 */
@Entity
@Table(name = "funcionarios")
public class FuncionarioModel {

    /**
     * Identificador da pessoa.
     */
    @Id
    private Integer idPessoa;

    /**
     * Número do PIS do funcionário.
     */
    @Column(name = "pis")
    private String pis;

    /**
     * Número da reservista do funcionário.
     */
    @Column(name = "reservista")
    private String reservista;

    /**
     * Número do título de eleitor do funcionário.
     */
    @Column(name = "titulo_eleitor")
    private String tituloEleitor;

    /**
     * Indica se o funcionário é CLT.
     */
    @Column(name = "bool_eClt", nullable = false)
    private Boolean boolEClt;

    /**
     * Data de contratação do funcionário.
     */
    @Column(name = "data_contratacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;

    /**
     * Data de cadastro do funcionário.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração do cadastro do funcionário.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
    
    /**
     * Construtor com parâmetros obrigatórios.
     * 
     * @param idPessoa Identificador da pessoa.
     * @param boolEClt Indica se o funcionário é CLT.
     * @param dataContratacao Data de contratação do funcionário.
     */
    public FuncionarioModel(Integer idPessoa, Boolean boolEClt, Date dataContratacao) {
        setIdPessoa(idPessoa);
        setBoolEClt(boolEClt);
        setDataContratacao(dataContratacao);
    }

    /**
     * Construtor com todos os parâmetros.
     * 
     * @param idPessoa Identificador da pessoa.
     * @param pis Número do PIS do funcionário.
     * @param reservista Número da reservista do funcionário.
     * @param tituloEleitor Número do título de eleitor do funcionário.
     * @param boolEClt Indica se o funcionário é CLT.
     * @param dataContratacao Data de contratação do funcionário.
     */
    public FuncionarioModel(Integer idPessoa, String pis, String reservista, String tituloEleitor, Boolean boolEClt, Date dataContratacao) {
        setIdPessoa(idPessoa);
        setPis(pis);
        setReservista(reservista);
        setTituloEleitor(tituloEleitor);
        setBoolEClt(boolEClt);
        setDataContratacao(dataContratacao);
    }

    /**
     * Construtor padrão.
     */
    public FuncionarioModel() {
    }

    /**
     * Obtém o identificador da pessoa.
     * 
     * @return Identificador da pessoa.
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * Define o identificador da pessoa.
     * 
     * @param idPessoa Identificador da pessoa.
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * Obtém o número do PIS do funcionário.
     * 
     * @return Número do PIS do funcionário.
     */
    public String getPis() {
        return pis;
    }

    /**
     * Define o número do PIS do funcionário.
     * 
     * @param pis Número do PIS do funcionário.
     */
    public void setPis(String pis) {
        this.pis = pis;
    }

    /**
     * Obtém o número da reservista do funcionário.
     * 
     * @return Número da reservista do funcionário.
     */
    public String getReservista() {
        return reservista;
    }

    /**
     * Define o número da reservista do funcionário.
     * 
     * @param reservista Número da reservista do funcionário.
     */
    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    /**
     * Obtém o número do título de eleitor do funcionário.
     * 
     * @return Número do título de eleitor do funcionário.
     */
    public String getTituloEleitor() {
        return tituloEleitor;
    }

    /**
     * Define o número do título de eleitor do funcionário.
     * 
     * @param tituloEleitor Número do título de eleitor do funcionário.
     */
    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    /**
     * Obtém a indicação se o funcionário é CLT.
     * 
     * @return Indicação se o funcionário é CLT.
     */
    public Boolean getBoolEClt() {
        return boolEClt;
    }

    /**
     * Define a indicação se o funcionário é CLT.
     * 
     * @param boolEClt Indicação se o funcionário é CLT.
     */
    public void setBoolEClt(Boolean boolEClt) {
        this.boolEClt = boolEClt;
    }

    /**
     * Obtém a data de contratação do funcionário.
     * 
     * @return Data de contratação do funcionário.
     */
    public Date getDataContratacao() {
        return dataContratacao;
    }

    /**
     * Define a data de contratação do funcionário.
     * 
     * @param dataContratacao Data de contratação do funcionário.
     */
    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    /**
     * Obtém a data de cadastro do funcionário.
     * 
     * @return Data de cadastro do funcionário.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração do cadastro do funcionário.
     * 
     * @return Data da última alteração do cadastro do funcionário.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }    
}
