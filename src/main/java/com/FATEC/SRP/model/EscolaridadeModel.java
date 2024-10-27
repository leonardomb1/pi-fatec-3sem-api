package com.FATEC.SRP.model;

import javax.persistence.*;

/**
 * Representa o modelo de Escolaridade.
 */
@Entity
@Table(name = "escolaridades")
public class EscolaridadeModel {

    /**
     * Identificador único da escolaridade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEscolaridade;

    /**
     * Nome da escolaridade.
     */
    @Column(name = "nomeEscolaridade")
    private String nomeEscolaridade;

    /**
     * Construtor padrão.
     */
    public EscolaridadeModel() {
    }

    /**
     * Obtém o nome da escolaridade.
     *
     * @param id O identificador da escolaridade.
     * @return O nome da escolaridade.
     */
    public String getEscolaridade(int id) {
        return this.nomeEscolaridade;
    }

    /**
     * Define o nome da escolaridade.
     *
     * @param escolaridade O nome da escolaridade.
     * @return O nome da escolaridade definido.
     */
    public String setEscolaridade(String escolaridade) {
        return this.nomeEscolaridade = escolaridade;
    }
}
