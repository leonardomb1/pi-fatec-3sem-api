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
@Table(name = "turmas")
public class TurmaModel {

    /**
     * Identificador único da turma.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    /**
     * Identificador do curso ao qual a turma pertence.
     */
    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    /**
     * Data de início da turma.
     */
    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    /**
     * Data de término da turma.
     */
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    /**
     * Período da turma (ex: manhã, tarde, noite).
     */
    @Column(name = "periodo", nullable = false)
    private String periodo;

    /**
     * Data de cadastro da turma.
     */
    @Column(name = "dt_cadastro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    /**
     * Data da última alteração da turma.
     */
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
}
