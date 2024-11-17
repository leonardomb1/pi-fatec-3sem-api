package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 * Representa a associação entre um aluno e uma turma. 
 * Esta classe é mapeada para a tabela "Aluno_Turmas" no banco de dados e mantém o controle de 
 * a relação entre alunos e suas turmas, incluindo o status de conclusão e as datas de cadastro e alteração.
 * 
 * Conceitos OOP utilizados:
 * - **Associação**: A relação entre a classe `AlunoTurmaModel`, `AlunoModel` e `TurmaModel` é um exemplo de associação de muitos para um.
 * - **Encapsulamento**: A classe encapsula todas as propriedades e comportamentos relacionados à associação entre aluno e turma.
 * - **Abstração**: A classe abstrai os detalhes da implementação de banco de dados ao representar a associação entre aluno e turma de forma lógica.
 */
@Getter
@Setter
@Entity
@Table(name="Aluno_Turmas")
public class AlunoTurmaModel {
    
    /**
     * Identificador único da associação entre aluno e turma.
     * Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Representa o aluno associado a esta turma. A relação é de muitos para um com a classe `AlunoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario")
    private AlunoModel aluno;
    
    /**
     * Representa a turma associada a este aluno. A relação é de muitos para um com a classe `TurmaModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id", referencedColumnName = "id")
    private TurmaModel turma;

    /**
     * Indica se o aluno concluiu a turma.
     */
    @Column(name = "concluido", nullable = false)
    private boolean concluido;
    
    /**
     * Data de cadastro da associação aluno-turma. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração na associação aluno-turma. Este campo é atualizado antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo registro de associação aluno-turma.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização de um registro existente de associação aluno-turma.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
