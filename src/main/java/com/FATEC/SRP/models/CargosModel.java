package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Classe que representa o modelo de Cargos.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Abstração: Representa um cargo com seus atributos e comportamentos.</li>
 *   <li>Herança: Utilização de anotações JPA para herdar comportamentos de persistência.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = CargosModel.TABLE_NAME)
public class CargosModel {
    static final String TABLE_NAME = "cargos";

    /**
     * Identificador único do cargo.
     * Gerado automaticamente pela estratégia de identidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    /**
     * Nome do cargo.
     * Não pode ser nulo ou vazio.
     */
    @Column(name = "nome_cargo", length = 50, nullable = false)
    @NotBlank(message = "Nome do cargo é obrigatório")
    private String nomeCargo;

    /**
     * Nível de permissão do cargo.
     * Não pode ser nulo.
     */
    @Column(name = "nivel_permissao", nullable = false)
    @NotNull(message = "Nível de permissão é obrigatório")
    private Integer nivelPermissao;

    /**
     * Data de cadastro do cargo.
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração do cargo.
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
