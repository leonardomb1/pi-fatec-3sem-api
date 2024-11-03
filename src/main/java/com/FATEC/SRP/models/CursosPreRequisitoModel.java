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
@IdClass(PreRequisitoIdModel.class)
public class PreRequisitoModel {

    static final String TABLE_NAME = "pre_requisitos";

    @EmbeddedId
    private PreRequisitoIdModel id;

    /**
     * Data de cadastro do registro.
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro do registro.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @ManyToOne
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso", nullable = false)
    @NotNull
    private CursosModel curso;

    @ManyToOne
    @MapsId("idPreRequisito")
    @JoinColumn(name = "id_PreRequisito", nullable = false)
    @NotNull
    private ClassificacoesModel classificacao;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}