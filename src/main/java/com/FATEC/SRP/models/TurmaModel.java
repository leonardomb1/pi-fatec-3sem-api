package com.fatec.srp.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Representa uma turma no sistema, associada a um curso e com informações sobre a data de início, término e período.
 * Esta classe é mapeada para a tabela "Turmas" no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Turmas")
public class TurmaModel {

    /**
     * Identificador único da turma.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Curso associado à turma. Relacionamento de muitos para um com a classe `CursoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    private CursoModel curso;

    /**
     * Data de início da turma.
     */
    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    /**
     * Data de término da turma.
     */
    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    /**
     * Período em que a turma ocorre (ex: "Manhã", "Tarde", "Noite").
     */
    @Column(name = "periodo", nullable = false, length = 15)
    private String periodo;

    /**
     * Data de cadastro da turma. Não pode ser alterada após o cadastro.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Lista de associações entre funcionários e turmas. Relacionamento de um para muitos com a classe `FuncionarioTurmaModel`.
     */
    @OneToMany(mappedBy = "turma")
    private List<FuncionarioTurmaModel> funcionarioTurma;

    /**
     * Data da última alteração na turma.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Lista de associações entre alunos e turmas. Relacionamento de um para muitos com a classe `AlunoTurmaModel`.
     */
    @OneToMany(mappedBy = "turma")
    private List<AlunoTurmaModel> alunoTurma;

    /**
     * Método que é chamado antes de persistir o objeto, definindo a data de cadastro.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método que é chamado antes de atualizar o objeto, definindo a data da alteração.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
