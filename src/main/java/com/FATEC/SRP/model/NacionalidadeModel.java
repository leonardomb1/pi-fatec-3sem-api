package com.FATEC.SRP.model;

import javax.persistence.*;

/**
 * Representa o modelo de Nacionalidade.
 */
@Entity
@Table(name = "nacionalidades")
public class NacionalidadeModel {

    /**
     * Identificador único do país.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;

    /**
     * Nome do país.
     */
    @Column(name = "nomePais")
    private String nomePais;

    /**
     * Construtor padrão.
     */
    public NacionalidadeModel() {
    }

    /**
     * Obtém o nome do país com base no ID fornecido.
     *
     * @param id O ID do país.
     * @return O nome do país.
     */
    public String getPais(int id) {
        return this.nomePais;
    }
}
