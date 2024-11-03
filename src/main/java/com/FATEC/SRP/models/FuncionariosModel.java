package com.fatec.srp.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Representa o modelo de um Funcionário.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = FuncionariosModel.TABLE_NAME)
public class FuncionariosModel  extends PessoasModel {

    static final String TABLE_NAME = "funcionarios";

    /**
     * Número do PIS do funcionário.
     */
    @Column(name = "pis", length = 11, nullable = false)
    @NotBlank(message = "PIS é obrigatório")
    @Size (min = 11, max = 11, message = "PIS deve ter 11 dígitos")
    private String pis;

    /**
     * Número da reservista do funcionário.
     */
    @Column(name = "reservista", length = 12, nullable = false)
    @NotBlank(message = "Reservista é obrigatório")
    @Size (min = 12, max = 12, message = "Reservista deve ter 12 dígitos")
    private String reservista;

    /**
     * Número do título de eleitor do funcionário.
     */
    @Column(name = "titulo_eleitor", length = 12, nullable = false)
    @NotBlank(message = "Título de eleitor é obrigatório")
    @Size(min = 12, max = 12, message = "Título de eleitor deve ter 12 dígitos")
    private String tituloEleitor;

    /**
     * Indica se o funcionário é CLT.
     */
    @Column(name = "eClt", nullable = false)
    @NotNull(message = "Indicação de CLT é obrigatória")
    private Boolean eClt;    

    /**
     * Data de contratação do funcionário.
     */
    @Column(name = "dt_contratacao", nullable = false)
    @NotNull(message = "Data de contratação é obrigatória")
    private LocalDateTime dtContratacao;

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

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargosModel cargo;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }

    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
    }
}
