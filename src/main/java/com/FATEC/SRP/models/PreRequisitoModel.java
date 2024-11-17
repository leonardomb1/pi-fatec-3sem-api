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
 * Representa os pré-requisitos para cursos no sistema. Esta classe é mapeada para a tabela "Prerequisitos" no banco de dados.
 * Contém informações sobre os pré-requisitos, como nome, descrição, e as relações com os cursos que os utilizam.
 */
@Getter
@Setter
@Entity
@Table(name="Prerequisitos")
public class PreRequisitoModel {
    
    /**
     * Identificador único do pré-requisito.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Lista de associações entre pré-requisitos e cursos. Relacionamento de um para muitos com a classe `PreRequisitoCursoModel`.
     */
    @OneToMany(mappedBy = "preRequisito")
    private List<PreRequisitoCursoModel> preRequisitoCurso;

    /**
     * Nome do pré-requisito.
     */
    @Column(name = "nome_prerequisito", nullable = false, length = 30)
    private String nomePrerequisito;

    /**
     * Descrição detalhada do pré-requisito.
     */
    @Column(name = "desc_prerequisito", nullable = false, length = 100)
    private String descPrerequisito;

    /**
     * Data de cadastro do pré-requisito. Não pode ser alterada após o cadastro.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração do pré-requisito.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

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
