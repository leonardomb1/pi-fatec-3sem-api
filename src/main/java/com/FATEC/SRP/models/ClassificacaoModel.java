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
 * Representa a classificação de um curso ou outro tipo de conteúdo dentro de uma organização.
 * Esta classe é mapeada para a tabela "Classificacoes" no banco de dados e mantém informações sobre as classificações,
 * como o nome da classificação e as datas de cadastro e alteração.
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: A classe `ClassificacaoModel` encapsula as propriedades relacionadas a uma classificação e oferece métodos para acessar e modificar esses valores de forma segura.
 * - **Associação**: A relação entre `ClassificacaoModel` e `CursoClassificacaoModel` é de um para muitos, ou seja, uma classificação pode estar associada a múltiplos cursos.
 * - **Abstração**: A classe abstrai a representação de uma classificação dentro da organização, deixando os detalhes da implementação da persistência de dados no banco de dados para o Hibernate.
 */
@Getter
@Setter
@Entity
@Table(name="Classificacoes")
public class ClassificacaoModel {
    
    /**
     * Identificador único da classificação. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Lista de cursos associados a esta classificação. A relação é de um para muitos com a classe `CursoClassificacaoModel`.
     */
    @OneToMany(mappedBy = "classificacao")
    private List<CursoClassificacaoModel> classificacaoCurso;

    /**
     * Nome da classificação.
     * Este campo não pode ser nulo e tem um limite de 30 caracteres.
     */
    @Column(name = "nome_classificacao", nullable = false, length = 30)
    private String nomeClassificacao;

    /**
     * Data de cadastro da classificação. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração na classificação. Este campo é atualizado antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo registro de classificação.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização de um registro de classificação existente.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
