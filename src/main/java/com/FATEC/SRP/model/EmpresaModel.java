package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Representa uma entidade Empresa no sistema.
 * Mapeia a tabela "empresas" no banco de dados.
 */
@Entity
@Table(name = "empresas")
public class EmpresaModel {

    /**
     * Identificador único da empresa.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    /**
     * Razão social da empresa.
     * Campo obrigatório.
     */
    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    /**
     * Nome fantasia da empresa.
     * Campo opcional.
     */
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    /**
     * CNPJ da empresa.
     * Campo obrigatório.
     */
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    /**
     * Endereço da empresa.
     * Campo obrigatório.
     */
    @Column(name = "endereco", nullable = false)
    private String endereco;

    /**
     * Banco da empresa.
     * Campo obrigatório.
     */
    @Column(name = "banco", nullable = false)
    private String banco;

    /**
     * Agência bancária da empresa.
     * Campo obrigatório.
     */
    @Column(name = "agencia", nullable = false)
    private String agencia;

    /**
     * Data de cadastro da empresa.
     * Não pode ser atualizada após a criação.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração dos dados da empresa.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor padrão.
     */
    public EmpresaModel() {
    }

    /**
     * Construtor com todos os campos, exceto id e datas.
     * 
     * @param razaoSocial Razão social da empresa.
     * @param nomeFantasia Nome fantasia da empresa.
     * @param cnpj CNPJ da empresa.
     * @param endereco Endereço da empresa.
     * @param banco Banco da empresa.
     * @param agencia Agência bancária da empresa.
     */
    public EmpresaModel(String razaoSocial, String nomeFantasia, String cnpj, String endereco, String banco, String agencia) {
        setRazaoSocial(razaoSocial);
        setNomeFantasia(nomeFantasia);
        setCnpj(cnpj);
        setEndereco(endereco);
        setBanco(banco);
        setAgencia(agencia);
    }

    /**
     * Construtor sem o campo nome fantasia.
     * 
     * @param razaoSocial Razão social da empresa.
     * @param cnpj CNPJ da empresa.
     * @param endereco Endereço da empresa.
     * @param banco Banco da empresa.
     * @param agencia Agência bancária da empresa.
     */
    public EmpresaModel(String razaoSocial, String cnpj, String endereco, String banco, String agencia) {
        setRazaoSocial(razaoSocial);
        setCnpj(cnpj);
        setEndereco(endereco);
        setBanco(banco);
        setAgencia(agencia);
    }

    /**
     * Obtém o identificador único da empresa.
     * 
     * @return Identificador da empresa.
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Obtém a razão social da empresa.
     * 
     * @return Razão social da empresa.
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Define a razão social da empresa.
     * 
     * @param razaoSocial Razão social da empresa.
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * Obtém o nome fantasia da empresa.
     * 
     * @return Nome fantasia da empresa.
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Define o nome fantasia da empresa.
     * 
     * @param nomeFantasia Nome fantasia da empresa.
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Obtém o CNPJ da empresa.
     * 
     * @return CNPJ da empresa.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ da empresa.
     * 
     * @param cnpj CNPJ da empresa.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Obtém o endereço da empresa.
     * 
     * @return Endereço da empresa.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da empresa.
     * 
     * @param endereco Endereço da empresa.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o banco da empresa.
     * 
     * @return Banco da empresa.
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Define o banco da empresa.
     * 
     * @param banco Banco da empresa.
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Obtém a agência bancária da empresa.
     * 
     * @return Agência bancária da empresa.
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Define a agência bancária da empresa.
     * 
     * @param agencia Agência bancária da empresa.
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * Obtém a data de cadastro da empresa.
     * 
     * @return Data de cadastro da empresa.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração dos dados da empresa.
     * 
     * @return Data da última alteração dos dados da empresa.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
