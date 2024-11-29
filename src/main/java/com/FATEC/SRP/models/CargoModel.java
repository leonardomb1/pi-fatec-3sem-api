package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * Representa o modelo de um cargo dentro de uma organização.
 * Esta classe é mapeada para a tabela "Cargos" no banco de dados e mantém informações sobre os cargos,
 * como nome, nível de permissão e as datas de cadastro e alteração.
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: A classe `CargoModel` encapsula as propriedades relacionadas a um cargo e permite o acesso a essas propriedades através de getters e setters.
 * - **Associação**: A relação entre `CargoModel` e `FuncionarioModel` é de um para muitos, onde um cargo pode ser atribuído a muitos funcionários.
 * - **Abstração**: A classe abstrai os detalhes da implementação dos cargos em uma organização e oferece um modelo para os dados que serão armazenados no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Cargos")
public class CargoModel {
    
    /**
     * Identificador único do cargo. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Lista de funcionários associados a este cargo. A relação é de um para muitos com a classe `FuncionarioModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "cargo")
    private List<FuncionarioModel> funcionario;

    /**
     * Nome do cargo.
     * Este campo não pode ser nulo e tem um limite de 100 caracteres.
     */
    @Column(name = "nome_cargo", nullable = false, length = 100)
    private String nomeCargo;

    /**
     * Nível de permissão associado ao cargo.
     * Este campo não pode ser nulo e representa a hierarquia ou privilégio do cargo dentro da organização.
     */
    @Column(name = "nivel_permissao", nullable = false)
    private int nivelPermissao;

    /**
     * Data de cadastro do cargo. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cargo. Este campo é atualizado antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo registro de cargo.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização de um registro de cargo existente.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
