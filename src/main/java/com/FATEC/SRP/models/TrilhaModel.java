package com.fatec.srp.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Representa o modelo de uma Turma.
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "trilhas")
public class TrilhaModel {

    /**
     * Identificador único da trilha.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrilha;

    /**
     * Nome da trilha.
     */
    @Column(name = "nome_trilha", nullable = false)
    private String nomeTrilha;

    /**
     * Descrição da trilha.
     */
    @Column(name = "desc_trilha")
    private String descTrilha;

    /**
     * Data de cadastro da trilha.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração da trilha.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
}
