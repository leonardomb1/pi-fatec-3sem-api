package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoas")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @Column(name = "nome_pessoa", nullable = false)
    private String nomePessoa;

    @Column(name = "nome_social")
    private String nomeSocial;

    @Column(name = "cgp_pessoa", nullable = false)
    private String cgpPessoa;

    @Column(name = "rg_pessoa", nullable = false)
    private String rgPessoa;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;

    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    public PessoaModel() {
    }

    public PessoaModel(String nomePessoa, String nomeSocial, String cgpPessoa, String rgPessoa, Date dataNascimento, String endereco, String nomeUsuario, String senhaUsuario) {
        setNomePessoa(nomePessoa);
        setNomeSocial(nomeSocial);
        setCgpPessoa(cgpPessoa);
        setRgPessoa(rgPessoa);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        setNomeUsuario(nomeUsuario);
        setSenhaUsuario(senhaUsuario);
    }

    public PessoaModel(String nomePessoa, String cgpPessoa, String rgPessoa, Date dataNascimento, String endereco, String nomeUsuario, String senhaUsuario) {
        setNomePessoa(nomePessoa);
        setCgpPessoa(cgpPessoa);
        setRgPessoa(rgPessoa);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        setNomeUsuario(nomeUsuario);
        setSenhaUsuario(senhaUsuario);
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCgpPessoa() {
        return cgpPessoa;
    }

    public void setCgpPessoa(String cgpPessoa) {
        this.cgpPessoa = cgpPessoa;
    }

    public String getRgPessoa() {
        return rgPessoa;
    }

    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

}
