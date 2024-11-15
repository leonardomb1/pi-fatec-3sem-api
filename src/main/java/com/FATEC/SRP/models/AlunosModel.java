package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Classe AlunosModel que representa a entidade Alunos no banco de dados.
 *  
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Herança: Utilização de anotações JPA para herdar comportamentos de persistência.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = AlunosModel.TABLE_NAME)
public class AlunosModel extends PessoasModel {
    static final String TABLE_NAME = "alunos";

    /**
     * Identificador único do aluno.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Indica se a pessoa é candidata.
     */
    @Column(name = "eCandidato", nullable = false)
    @NotNull(message = "Campo eCandidato é obrigatório")
    private Boolean eCandidato;

    /**
     * Nome do banco.
     */
    @Column(name = "banco", length = 100, nullable = false)
    @NotBlank(message = "Banco é obrigatório")
    private String banco;

    /**
     * Agência bancária.
     */
    @Column(name = "agencia", length = 20, nullable = false)
    @NotBlank(message = "Agência é obrigatória")
    private String agencia;

    /**
     * Identificador da nacionalidade da pessoa.
     */
    @Column(name = "nacionalidade", length = 50, nullable = false)
    @NotBlank(message = "Nacionalidade é obrigatória")
    private String nacionalidade;

    /**
     * Naturalidade da pessoa.
     */
    @Column(name = "naturalidade", length = 50, nullable = false)
    @NotBlank(message = "Naturalidade é obrigatória")
    private String naturalidade;

    /**
     * Identificador da empresa associada.
     * 
     * @ManyToOne: Indica um relacionamento muitos-para-um com a entidade EmpresasModel.
     * @JoinColumn: Especifica a coluna de junção para o relacionamento.
     */
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresasModel empresa;

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