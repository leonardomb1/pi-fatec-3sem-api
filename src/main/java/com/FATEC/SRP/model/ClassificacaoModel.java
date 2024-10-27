package com.FATEC.SRP.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Classe que representa o modelo de Classificação.
 * Mapeia a entidade "classificacao" no banco de dados.
 */
@Entity
@Table(name = "classificacao")
public class ClassificacaoModel {

    /**
     * Identificador único da classificação.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClassificacao;

    /**
     * Nome da classificação.
     * Não pode ser nulo.
     */
    @Column(name = "nome_classificacao", nullable = false)
    private String nomeClassificacao;

    /**
     * Data de cadastro da classificação.
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração da classificação.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;

    /**
     * Construtor que inicializa a classificação com um nome.
     * 
     * @param nomeClassificacao Nome da classificação.
     */
    public ClassificacaoModel(String nomeClassificacao) {
        setNomeClassificacao(nomeClassificacao);
    }

    /**
     * Construtor padrão.
     */
    public ClassificacaoModel() {
    }

    /**
     * Obtém o identificador da classificação.
     * 
     * @return Identificador da classificação.
     */
    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    /**
     * Obtém o nome da classificação.
     * 
     * @return Nome da classificação.
     */
    public String getNomeClassificacao() {
        return nomeClassificacao;
    }

    /**
     * Define o nome da classificação.
     * 
     * @param nomeClassificacao Nome da classificação.
     */
    public void setNomeClassificacao(String nomeClassificacao) {
        this.nomeClassificacao = nomeClassificacao;
    }

    /**
     * Obtém a data de cadastro da classificação.
     * 
     * @return Data de cadastro da classificação.
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Obtém a data da última alteração da classificação.
     * 
     * @return Data da última alteração da classificação.
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }
}
