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
 * Representa uma trilha de aprendizado no sistema, contendo informações sobre o nome e descrição da trilha.
 * Esta classe é mapeada para a tabela "Trilhas" no banco de dados.
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: Os campos como `nomeTrilha`, `descTrilha` e as listas de cursos estão encapsulados, garantindo que o acesso e modificação sejam controlados.
 * - **Associação**: A classe possui uma associação de um para muitos com `CursoTrilhaModel`, indicando que uma trilha pode estar associada a vários cursos.
 * - **Abstração**: A classe abstrai as informações sobre a trilha e seus cursos, permitindo que o sistema manipule esses dados de forma simplificada sem expor a implementação interna.
 * - **Modificação de Estado**: A classe possui métodos que alteram o estado do objeto, como as datas de cadastro e alteração, que são automaticamente configuradas no momento de persistência e atualização.
 */
@Getter
@Setter
@Entity
@Table(name="Trilhas")
public class TrilhaModel {
    
    /**
     * Identificador único da trilha.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Lista de associações entre trilhas e cursos. Relacionamento de um para muitos com a classe `CursoTrilhaModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "trilha")
    private List<CursoTrilhaModel> trilhaCurso;

    /**
     * Nome da trilha.
     */
    @Column(name = "nome_trilha", nullable = false, length = 100)
    private String nomeTrilha;

    /**
     * Descrição detalhada da trilha.
     */
    @Column(name = "desc_trilha", nullable = false, length = 100)
    private String descTrilha;

    /**
     * Data de cadastro da trilha. Não pode ser alterada após o cadastro.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração da trilha.
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
