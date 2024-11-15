package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa o modelo de Pré-Requisito.
 * Utiliza anotações do Lombok para geração automática de getters, setters, construtores e builder.
 * Utiliza anotações do JPA para mapeamento da entidade e suas colunas no banco de dados.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Abstração: Representação de um pré-requisito com atributos e comportamentos específicos.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto Builder para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "pre_requisitos")
public class PreRequisitoModel {

    static final String TABLE_NAME = "pre_requisitos";

    /**
     * Identificador único do pré-requisito.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Título do pré-requisito.
     * Deve ter entre 5 e 40 caracteres.
     * É obrigatório.
     */
    @NotEmpty(message = "Titulo é obrigatório")
    @Column(name = "titulo", length = 40, nullable = true)
    @Size(min = 5, max = 40)
    private String titulo;

    /**
     * Descrição do pré-requisito.
     * Deve ter entre 5 e 100 caracteres.
     * É obrigatória.
     */
    @NotEmpty(message = "Descrição é obrigatória")
    @Column(name = "descricao", length = 100, nullable = true)
    @Size(min = 5, max = 100)
    private String descricao;

    /**
     * Data de cadastro do pré-requisito.
     * Preenchida automaticamente na criação do registro.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data de alteração do pré-requisito.
     * Atualizada automaticamente na modificação do registro.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

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