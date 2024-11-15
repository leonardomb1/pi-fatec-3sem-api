package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Classe que representa a entidade de classificação de cursos.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Abstração: Representa uma classificação de curso com seus atributos e comportamentos.</li>
 *   <li>Herança: Utilização de anotações JPA para herdar comportamentos de persistência.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
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
@Table(name = ClassificacoesCursosModel.TABLE_NAME)
public class ClassificacoesCursosModel {

    /**
     * Nome da tabela no banco de dados.
     */
    static final String TABLE_NAME = "classificacoes_cursos";

    /**
     * Identificador composto da classificação do curso.
     * Utiliza a anotação @EmbeddedId para indicar que é uma chave primária composta.
     */
    @EmbeddedId
    private ClassificacoesCursosId id;

    /**
     * Data de cadastro do registro.
     * 
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro do registro.
     * 
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Curso associado à classificação.
     * Utiliza a anotação @ManyToOne para indicar o relacionamento muitos-para-um.
     * 
     * @MapsId("idCurso") Mapeia o campo idCurso da chave composta.
     * @JoinColumn(name = "id_curso", nullable = false) Especifica a coluna de junção no banco de dados e que não pode ser nula.
     * @NotNull Indica que o campo não pode ser nulo.
     */
    @ManyToOne
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso", nullable = false)
    @NotNull
    private CursosModel curso;

    /**
     * Classificação associada ao curso.
     * Utiliza a anotação @ManyToOne para indicar o relacionamento muitos-para-um.
     * 
     * @MapsId("idClassificacao") Mapeia o campo idClassificacao da chave composta.
     * @JoinColumn(name = "id_classificacao", nullable = false) Especifica a coluna de junção no banco de dados e que não pode ser nula.
     * @NotNull Indica que o campo não pode ser nulo.
     */
    @ManyToOne
    @MapsId("idClassificacao")
    @JoinColumn(name = "id_classificacao", nullable = false)
    @NotNull
    private ClassificacoesModel classificacao;

    /**
     * Método executado antes de persistir um novo registro.
     * Define a data de cadastro como a data e hora atual.
     * 
     * @PrePersist Indica que o método deve ser executado antes de persistir o registro.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método executado antes de atualizar um registro existente.
     * Define a data de alteração como a data e hora atual.
     * 
     * @PreUpdate Indica que o método deve ser executado antes de atualizar o registro.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}

