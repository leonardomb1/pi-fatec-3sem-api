package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Representa a associação entre um funcionário e uma turma. Esta classe é mapeada para a tabela "funcionario_turmas" no banco de dados.
 * Contém informações sobre o funcionário, a turma e a razão social associada.
 */
@Getter
@Setter
@Entity
@Table(name="funcionario_turmas")
public class FuncionarioTurmaModel {
    
    /**
     * Identificador único da associação entre o funcionário e a turma.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Funcionário associado à turma. Relacionamento de muitos para um com a classe `FuncionarioModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "funcionario_id", referencedColumnName = "nome_usuario")
    private FuncionarioModel funcionario; 

    /**
     * Turma associada ao funcionário. Relacionamento de muitos para um com a classe `TurmaModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "turma_id", referencedColumnName = "id")
    private TurmaModel turma;

    /**
     * Razão social associada à turma. Pode ser usada para especificar a empresa ou instituição que oferece a turma.
     */
    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    /**
     * Data de cadastro da associação entre o funcionário e a turma. Este campo não pode ser alterado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração nos dados da associação entre o funcionário e a turma.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência da associação entre o funcionário e a turma.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização dos dados da associação entre o funcionário e a turma.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
