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
 * Modelo que representa os pré-requisitos de um curso.
 * Utiliza anotações do JPA para mapeamento objeto-relacional.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Atributos privados com getters e setters.</li>
 *   <li>Herança: Utilização de anotações que estendem funcionalidades.</li>
 *   <li>Composição: Relacionamento com outras entidades (CursosModel e ClassificacoesModel).</li>
 *   <li>Construtores: Construtores padrão e com argumentos são gerados pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
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

    /**
     * Identificador composto do pré-requisito.
     */
    @EmbeddedId
    private PreRequisitoIdModel id;

    /**
     * Data de cadastro do pré-requisito.
     * Este campo não é atualizável.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data de alteração do pré-requisito.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Curso ao qual o pré-requisito está associado.
     * Não pode ser nulo.
     */
    @ManyToOne
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso", nullable = false)
    @NotNull
    private CursosModel curso;

    /**
     * Classificação do pré-requisito.
     * Não pode ser nulo.
     */
    @ManyToOne
    @MapsId("idPreRequisito")
    @JoinColumn(name = "id_PreRequisito", nullable = false)
    @NotNull
    private ClassificacoesModel classificacao;

    /**
     * Método executado antes de persistir a entidade.
     * Define a data de cadastro como o momento atual.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método executado antes de atualizar a entidade.
     * Define a data de alteração como o momento atual.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}