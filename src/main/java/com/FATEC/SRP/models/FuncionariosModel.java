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
 * Classe FuncionariosModel que representa a entidade Funcionários no banco de dados.
 * Esta classe herda de PessoasModel e utiliza anotações JPA para mapeamento objeto-relacional.
 * 
 * <p>POO (Programação Orientada a Objetos) conceitos utilizados:
 * <ul>
 *   <li>Herança: FuncionariosModel herda de PessoasModel.</li>
 *   <li>Encapsulamento: Atributos privados com getters e setters públicos.</li>
 *   <li>Associação: Relacionamento ManyToOne com a classe CargosModel.</li>
 * </ul>
 * </p>
 * 
 * @see PessoasModel
 * @see CargosModel
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = FuncionariosModel.TABLE_NAME)
public class FuncionariosModel extends PessoasModel {

    static final String TABLE_NAME = "funcionarios";

    /**
     * Número de Identificação Social (PIS) do funcionário.
     * Deve conter exatamente 11 dígitos.
     */
    @Column(name = "pis", length = 11, nullable = false)
    @NotBlank(message = "PIS é obrigatório")
    @Size(min = 11, max = 11, message = "PIS deve ter 11 dígitos")
    private String pis;

    /**
     * Número do certificado de reservista do funcionário.
     * Deve conter exatamente 12 dígitos.
     */
    @Column(name = "reservista", length = 12, nullable = false)
    @NotBlank(message = "Reservista é obrigatório")
    @Size(min = 12, max = 12, message = "Reservista deve ter 12 dígitos")
    private String reservista;

    /**
     * Número do título de eleitor do funcionário.
     * Deve conter exatamente 12 dígitos.
     */
    @Column(name = "titulo_eleitor", length = 12, nullable = false)
    @NotBlank(message = "Título de eleitor é obrigatório")
    @Size(min = 12, max = 12, message = "Título de eleitor deve ter 12 dígitos")
    private String tituloEleitor;

    /**
     * Indicação se o funcionário é contratado sob o regime CLT.
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
     * Nacionalidade do funcionário.
     */
    @Column(name = "nacionalidade", length = 50, nullable = false)
    @NotBlank(message = "Nacionalidade é obrigatória")
    private String nacionalidade;

    /**
     * Naturalidade do funcionário.
     */
    @Column(name = "naturalidade", length = 50, nullable = false)
    @NotBlank(message = "Naturalidade é obrigatória")
    private String naturalidade;

    /**
     * Cargo do funcionário.
     * Relacionamento ManyToOne com a entidade CargosModel.
     */
    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargosModel cargo;

    /**
     * Método executado antes de persistir um novo registro.
     * Define a data de cadastro como a data e hora atual.
     * 
     * @PrePersist Indica que o método deve ser executado antes de persistir o registro.
     */
    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }

    /**
     * Método executado antes de atualizar um registro existente.
     * Define a data de alteração como a data e hora atual.
     * 
     * @PreUpdate Indica que o método deve ser executado antes de atualizar o registro.
     */
    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
    }
}
