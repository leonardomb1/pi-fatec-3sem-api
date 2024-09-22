package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class ClienteModel {

    @Id
    private Integer idPessoa;

    @Column(name = "bool_eCandidato", nullable = false)
    private Boolean boolECandidato;

    @Column(name = "id_empresa")
    private Integer idEmpresa;

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

    public ClienteModel(Integer idPessoa, Boolean boolECandidato, String banco, String agencia) {
        setIdPessoa(idPessoa);
        setBoolECandidato(boolECandidato);
        setBanco(banco);
        setAgencia(agencia);
    }

    public ClienteModel(Integer idPessoa, Boolean boolECandidato, Integer idEmpresa, String banco, String agencia) {
        setIdPessoa(idPessoa);
        setBoolECandidato(boolECandidato);
        setIdEmpresa(idEmpresa);
        setBanco(banco);
        setAgencia(agencia);
    }

    public ClienteModel() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Boolean getBoolECandidato() {
        return boolECandidato;
    }

    public void setBoolECandidato(Boolean boolECandidato) {
        this.boolECandidato = boolECandidato;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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
