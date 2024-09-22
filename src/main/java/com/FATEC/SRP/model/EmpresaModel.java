package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empresas")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "banco", nullable = false)
    private String banco;

    @Column(name = "agencia", nullable = false)
    private String agencia;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    public EmpresaModel() {
    }

    public EmpresaModel( String razaoSocial, String nomeFantasia, String cnpj, String endereco, String banco, String agencia) {
        setRazaoSocial(razaoSocial);
        setNomeFantasia(nomeFantasia);
        setCnpj(cnpj);
        setEndereco(endereco);
        setBanco(banco);
        setAgencia(agencia);
    }

    public EmpresaModel(String razaoSocial, String cnpj, String endereco, String banco, String agencia) {
        setRazaoSocial(razaoSocial);
        setCnpj(cnpj);
        setEndereco(endereco);
        setBanco(banco);
        setAgencia(agencia);
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
