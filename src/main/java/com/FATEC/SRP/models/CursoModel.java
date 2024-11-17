package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Representa um curso na aplicação. 
 * Esta classe é mapeada para a tabela "Cursos" no banco de dados e mantém as informações sobre um curso,
 * incluindo suas turmas, classificações, requisitos e trilhas associadas.
 */
@Getter
@Setter
@Entity
@Table(name="Cursos")
public class CursoModel {
    
    /**
     * Identificador único do curso. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Lista de turmas associadas a este curso. Relacionamento de um para muitos com a classe `TurmaModel`.
     */
    @OneToMany(mappedBy = "curso")
    private List<TurmaModel> turma;

    /**
     * Lista de classificações associadas a este curso. Relacionamento de um para muitos com a classe `CursoClassificacaoModel`.
     */
    @OneToMany(mappedBy = "curso")
    private List<CursoClassificacaoModel> cursoClassificacao;

    /**
     * Lista de pré-requisitos associadas a este curso. Relacionamento de um para muitos com a classe `PreRequisitoCursoModel`.
     */
    @OneToMany(mappedBy = "curso")
    private List<PreRequisitoCursoModel> cursoRequisito;

    /**
     * Lista de trilhas associadas a este curso. Relacionamento de um para muitos com a classe `CursoTrilhaModel`.
     */
    @OneToMany(mappedBy = "curso")
    private List<CursoTrilhaModel> cursoTrilha;

    /**
     * Nome do curso. Este campo é obrigatório e possui um limite de 40 caracteres.
     */
    @Column(name = "nome_curso", nullable = false, length = 40)
    private String nomeCurso;

    /**
     * Descrição do curso. Este campo é obrigatório e possui um limite de 255 caracteres.
     */
    @Column(name = "desc_curso", nullable = false, length = 255)
    private String descCurso;

    /**
     * Programação do curso. Este campo é obrigatório e possui um limite de 255 caracteres.
     */
    @Column(name = "programacao", nullable = false, length = 255)
    private String programacao;

    /**
     * Data de cadastro do curso. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no curso. Este campo é atualizado automaticamente antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo curso.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes de cada atualização de um curso.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
