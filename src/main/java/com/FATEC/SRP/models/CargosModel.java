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
 * Representa um modelo de Cargo.
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
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;


    /**
     * Nome do cargo.
     */
    @Column(name = "nome_cargo", length = 50,nullable = false)
    @NotBlank(message = "Nome do cargo é obrigatório")
    private String nomeCargo;

    /**
     * Nível de permissão do cargo.
     */
    @Column(name = "nivel_permissao", nullable = false)
    @NotNull(message = "Nível de permissão é obrigatório")
    private Integer nivelPermissao;

    /**
     * Data de cadastro do cargo.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro do cargo.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;
    

        @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
