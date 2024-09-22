package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "funcionarios")
public class FuncionarioModel {

    @Id
    private Integer idPessoa;

    @Column(name = "pis")
    private String pis;

    @Column(name = "reservista")
    private String reservista;

    @Column(name = "titulo_eleitor")
    private String tituloEleitor;

    @Column(name = "bool_eClt", nullable = false)
    private Boolean boolEClt;

    @Column(name = "data_contratacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
    
    public FuncionarioModel(Integer idPessoa, Boolean boolEClt, Date dataContratacao) {
        setIdPessoa(idPessoa);
        setBoolEClt(boolEClt);
        setDataContratacao(dataContratacao);
    }

    public FuncionarioModel(Integer idPessoa, String pis, String reservista, String tituloEleitor, Boolean boolEClt, Date dataContratacao) {
        setIdPessoa(idPessoa);
        setPis(pis);
        setReservista(reservista);
        setTituloEleitor(tituloEleitor);
        setBoolEClt(boolEClt);
        setDataContratacao(dataContratacao);
    }

    public FuncionarioModel() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getReservista() {
        return reservista;
    }

    public void setReservista(String reservista) {
        this.reservista = reservista;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public Boolean getBoolEClt() {
        return boolEClt;
    }

    public void setBoolEClt(Boolean boolEClt) {
        this.boolEClt = boolEClt;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }    
}
