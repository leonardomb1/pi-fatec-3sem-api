package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Entidade que representa uma pessoa.
 */
@Entity
@Table(name = "pessoas")
public class PessoaModel {

    /**
     * Identificador único da pessoa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    /**
     * Nome da pessoa.
     */
    @Column(name = "nome_pessoa", nullable = false)
    private String nomePessoa;

    /**
     * Nome social da pessoa.
     */
    @Column(name = "nome_social")
    private String nomeSocial;

    /**
     * CPF da pessoa.
     */
    @Column(name = "cgp_pessoa", nullable = false)
    private String cgpPessoa;

    /**
     * RG da pessoa.
     */
    @Column(name = "rg_pessoa", nullable = true)
    private String rgPessoa;

    /**
     * RNE da pessoa.
     */
    @Column(name = "rne_pessoa", nullable = true)
    private String rnePessoa;

    /**
     * Email da pessoa.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Celular da pessoa.
     */
    @Column(name = "celular", nullable = false)
    private String celular;

    /**
     * Telefone da pessoa.
     */
    @Column(name = "telefone", nullable = false)
    private String telefone;

    /**
     * Identificador da nacionalidade da pessoa.
     */
    @Column(name = "idNacionalidade", nullable = false)
    private int idNacionalidade; // criar tabela de nacionalidade

    /**
     * Naturalidade da pessoa.
     */
    @Column(name = "naturalidade", nullable = false)
    private String naturalidade;

    /**
     * Identificador da escolaridade da pessoa.
     */
    @Column(name = "idEscolaridade", nullable = false)
    private int idEscolaridade; // criar tabela de escolaridade

    /**
     * Identificador do local de escolaridade da pessoa.
     */
    @Column(name = "idLocalEscolaridade", nullable = false)
    private int idLocalEscolaridade; // criar tabela de escolaridade

    /**
     * Data de nascimento da pessoa.
     */
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    /**
     * Endereço da pessoa.
     */
    @Column(name = "endereco", nullable = false)
    private String endereco;

    /**
     * Nome de usuário da pessoa.
     */
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    /**
     * Senha do usuário.
     */
    @Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;

    /**
     * Data de cadastro da pessoa.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração dos dados da pessoa.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor padrão.
     */
    public PessoaModel() {
    }

    /**
     * Construtor com parâmetros.
     *
     * @param nomePessoa Nome da pessoa.
     * @param nomeSocial Nome social da pessoa.
     * @param cgpPessoa CPF da pessoa.
     * @param rgPessoa RG da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     * @param endereco Endereço da pessoa.
     * @param nomeUsuario Nome de usuário da pessoa.
     * @param senhaUsuario Senha do usuário.
     */
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

    /**
     * Construtor com parâmetros.
     *
     * @param nomePessoa Nome da pessoa.
     * @param cgpPessoa CPF da pessoa.
     * @param rgPessoa RG da pessoa.
     * @param dataNascimento Data de nascimento da pessoa.
     * @param endereco Endereço da pessoa.
     * @param nomeUsuario Nome de usuário da pessoa.
     * @param senhaUsuario Senha do usuário.
     */
    public PessoaModel(String nomePessoa, String cgpPessoa, String rgPessoa, Date dataNascimento, String endereco, String nomeUsuario, String senhaUsuario) {
        setNomePessoa(nomePessoa);
        setCgpPessoa(cgpPessoa);
        setRgPessoa(rgPessoa);
        setDataNascimento(dataNascimento);
        setEndereco(endereco);
        setNomeUsuario(nomeUsuario);
        setSenhaUsuario(senhaUsuario);
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
     * Obtém o nome da pessoa.
     *
     * @return Nome da pessoa.
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nomePessoa Nome da pessoa.
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * Obtém o nome social da pessoa.
     *
     * @return Nome social da pessoa.
     */
    public String getNomeSocial() {
        return nomeSocial;
    }

    /**
     * Define o nome social da pessoa.
     *
     * @param nomeSocial Nome social da pessoa.
     */
    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    /**
     * Obtém o CPF da pessoa.
     *
     * @return CPF da pessoa.
     */
    public String getCgpPessoa() {
        return cgpPessoa;
    }

    /**
     * Define o CPF da pessoa.
     *
     * @param cgpPessoa CPF da pessoa.
     */
    public void setCgpPessoa(String cgpPessoa) {
        this.cgpPessoa = cgpPessoa;
    }

    /**
     * Obtém o RG da pessoa.
     *
     * @return RG da pessoa.
     */
    public String getRgPessoa() {
        return rgPessoa;
    }

    /**
     * Define o RG da pessoa.
     *
     * @param rgPessoa RG da pessoa.
     */
    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    /**
     * Obtém a data de nascimento da pessoa.
     *
     * @return Data de nascimento da pessoa.
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento da pessoa.
     *
     * @param dataNascimento Data de nascimento da pessoa.
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o endereço da pessoa.
     *
     * @return Endereço da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da pessoa.
     *
     * @param endereco Endereço da pessoa.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém o nome de usuário da pessoa.
     *
     * @return Nome de usuário da pessoa.
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Define o nome de usuário da pessoa.
     *
     * @param nomeUsuario Nome de usuário da pessoa.
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return Senha do usuário.
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senhaUsuario Senha do usuário.
     */
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    /**
     * Obtém a data de cadastro da pessoa.
     *
     * @return Data de cadastro da pessoa.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração dos dados da pessoa.
     *
     * @return Data da última alteração dos dados da pessoa.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }

}
