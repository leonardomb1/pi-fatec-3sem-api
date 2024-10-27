package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa um cliente no sistema.
 */
@Entity
@Table(name = "clientes")
public class ClienteModel {

    /**
     * Identificador único da pessoa.
     */
    @Id
    private Integer idPessoa;

    /**
     * Indica se a pessoa é candidata.
     */
    @Column(name = "bool_eCandidato", nullable = false)
    private Boolean boolECandidato;

    /**
     * Identificador da empresa associada.
     */
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    /**
     * Nome do banco.
     */
    @Column(name = "banco", nullable = false)
    private String banco;

    /**
     * Agência bancária.
     */
    @Column(name = "agencia", nullable = false)
    private String agencia;

    /**
     * Data de cadastro do cliente.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração no cadastro do cliente.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor com parâmetros obrigatórios.
     *
     * @param idPessoa Identificador único da pessoa.
     * @param boolECandidato Indica se a pessoa é candidata.
     * @param banco Nome do banco.
     * @param agencia Agência bancária.
     */
    public ClienteModel(Integer idPessoa, Boolean boolECandidato, String banco, String agencia) {
        setIdPessoa(idPessoa);
        setBoolECandidato(boolECandidato);
        setBanco(banco);
        setAgencia(agencia);
    }

    /**
     * Construtor com todos os parâmetros.
     *
     * @param idPessoa Identificador único da pessoa.
     * @param boolECandidato Indica se a pessoa é candidata.
     * @param idEmpresa Identificador da empresa associada.
     * @param banco Nome do banco.
     * @param agencia Agência bancária.
     */
    public ClienteModel(Integer idPessoa, Boolean boolECandidato, Integer idEmpresa, String banco, String agencia) {
        setIdPessoa(idPessoa);
        setBoolECandidato(boolECandidato);
        setIdEmpresa(idEmpresa);
        setBanco(banco);
        setAgencia(agencia);
    }

    /**
     * Construtor padrão.
     */
    public ClienteModel() {
    }

    /**
     * Obtém o identificador único da pessoa.
     *
     * @return Identificador único da pessoa.
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * Define o identificador único da pessoa.
     *
     * @param idPessoa Identificador único da pessoa.
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * Verifica se a pessoa é candidata.
     *
     * @return true se a pessoa é candidata, false caso contrário.
     */
    public Boolean getBoolECandidato() {
        return boolECandidato;
    }

    /**
     * Define se a pessoa é candidata.
     *
     * @param boolECandidato true se a pessoa é candidata, false caso contrário.
     */
    public void setBoolECandidato(Boolean boolECandidato) {
        this.boolECandidato = boolECandidato;
    }

    /**
     * Obtém o identificador da empresa associada.
     *
     * @return Identificador da empresa associada.
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Define o identificador da empresa associada.
     *
     * @param idEmpresa Identificador da empresa associada.
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Obtém o nome do banco.
     *
     * @return Nome do banco.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Define o nome do banco.
     *
     * @param banco Nome do banco.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Obtém a agência bancária.
     *
     * @return Agência bancária.
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Define a agência bancária.
     *
     * @param agencia Agência bancária.
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * Obtém a data de cadastro do cliente.
     *
     * @return Data de cadastro do cliente.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração no cadastro do cliente.
     *
     * @return Data da última alteração no cadastro do cliente.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
