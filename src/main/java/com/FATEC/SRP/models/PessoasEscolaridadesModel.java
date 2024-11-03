package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Entidade que representa uma pessoa.
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = PessoasEscolaridadesModel.TABLE_NAME)
public class PessoasEscolaridadesModel {
    static final String TABLE_NAME = "pessoas_Escolaridades";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ano_conclusao", nullable = false)
    @NotNull(message = "Ano de conclusão é obrigatório")
    private LocalDateTime anoConclusao;

    @Column(name = "ano_ingresso", nullable = false)
    @NotNull(message = "Ano de ingresso é obrigatório")
    private LocalDateTime anoIngresso;

    @Column(name = "instituicao", nullable = false)
    @NotNull(message = "Instituição é obrigatório")
    private String instituicao;
    
    /**
     * Identificador da pessoa.
     */
    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoasModel pessoa;

    /**
     * Identificador do nivel de escolaridade da pessoa.
     */
    @ManyToOne
    @JoinColumn(name = "id_nivel", nullable = false)
    private EscolaridadesModel nivel;

}
