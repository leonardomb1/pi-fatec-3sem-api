package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa o modelo de pré-requisitos de um curso.
 * Esta classe é mapeada para a tabela "pre_requisitos" no banco de dados.
 * Utiliza a classe PreRequisitoIdModel como chave composta.
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "pre_requisitos")
public class PreRequisitoModel {

    static final String TABLE_NAME = "pre_requisitos";

        /**
     * Identificador único da pessoa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Titulo do requisito.
     */
    @NotEmpty(message = "Titulo é obrigatório")
    @Column(name = "titulo", length = 40, nullable = true)
    @Size(min = 5, max = 40)
    private String titulo;

    /**
     * Descrição do requisito.
     */
    @NotEmpty(message = "Descrição é obrigatória")
    @Column(name = "descricao", length = 100, nullable = true)
    @Size(min = 5, max = 100)
    private String descricao;

    /**
     * Data de cadastro da pessoa.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro da pessoa.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}