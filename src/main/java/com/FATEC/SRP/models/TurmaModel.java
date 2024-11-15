package com.fatec.srp.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * A classe TurmaModel representa uma entidade de turma no sistema.
 * Utiliza anotações do JPA para mapeamento objeto-relacional.
 * 
 * <p>Esta classe demonstra o uso de conceitos de POO como encapsulamento,
 * através do uso de getters e setters, e construção de objetos com o padrão
 * Builder.</p>
 * 
 * <p>As anotações Lombok (@Getter, @Setter, @AllArgsConstructor, @Builder, @NoArgsConstructor)
 * são usadas para reduzir o código boilerplate.</p>
 * 
 * <p>A anotação @Entity indica que esta classe é uma entidade JPA.</p>
 * <p>A anotação @Table especifica a tabela correspondente no banco de dados.</p>
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
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    /**
     * Identificador do curso ao qual a turma pertence.
     * Não pode ser nulo.
     */
    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    /**
     * Data de início da turma.
     * Não pode ser nula.
     */
    @Column(name = "data_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    /**
     * Data de término da turma.
     * Pode ser nula.
     */
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    /**
     * Período da turma (ex: manhã, tarde, noite).
     * Não pode ser nulo.
     */
    @Column(name = "periodo", nullable = false)
    private String periodo;

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
