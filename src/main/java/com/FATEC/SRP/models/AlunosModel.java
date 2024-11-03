package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Representa um cliente no sistema.
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
     */
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresasModel empresa;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }

    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
}
}