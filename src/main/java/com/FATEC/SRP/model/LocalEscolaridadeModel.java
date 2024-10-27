package com.FATEC.SRP.model;

import javax.persistence.*;

/**
 * Representa o modelo de LocalEscolaridade.
 */
@Entity
@Table(name = "local_escolaridade")
public class LocalEscolaridadeModel {

    /**
     * Identificador único do LocalEscolaridade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEscolaridadeLocal;

    /**
     * Nome do LocalEscolaridade.
     */
    @Column(name = "nomeEscolaridadeLocal")
    private String nomeEscolaridadeLocal;

    /**
     * Construtor padrão.
     */
    public LocalEscolaridadeModel() {
    }

    /**
     * Retorna o nome do LocalEscolaridade com base no ID fornecido.
     *
     * @param id O ID do LocalEscolaridade.
     * @return O nome do LocalEscolaridade.
     */
    public String getEscolaridadeLocal(int id) {
        return this.nomeEscolaridadeLocal;
    }
}
