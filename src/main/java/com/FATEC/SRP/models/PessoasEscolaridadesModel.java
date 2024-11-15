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
 * Modelo que representa a relação entre pessoas e suas escolaridades.
 * Utiliza anotações do Lombok para geração automática de getters, setters, construtores e builder.
 * Anotado como uma entidade JPA para mapeamento com a tabela "pessoas_Escolaridades".
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
    
    /**
     * Identificador único da relação pessoa-escolaridade.
     * Gerado automaticamente pela estratégia de identidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Ano de conclusão da escolaridade.
     * Não pode ser nulo.
     */
    @Column(name = "ano_conclusao", nullable = false)
    @NotNull(message = "Ano de conclusão é obrigatório")
    private LocalDateTime anoConclusao;

    /**
     * Ano de ingresso na escolaridade.
     * Não pode ser nulo.
     */
    @Column(name = "ano_ingresso", nullable = false)
    @NotNull(message = "Ano de ingresso é obrigatório")
    private LocalDateTime anoIngresso;

    /**
     * Nome da instituição de ensino.
     * Não pode ser nulo.
     */
    @Column(name = "instituicao", nullable = false)
    @NotNull(message = "Instituição é obrigatório")
    private String instituicao;

    /**
     * Pessoa associada a esta escolaridade.
     * Mapeamento ManyToOne com a entidade PessoasModel.
     * Não pode ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoasModel pessoa;

    /**
     * Nível de escolaridade associado.
     * Mapeamento ManyToOne com a entidade EscolaridadesModel.
     * Não pode ser nulo.
     */
    @ManyToOne
    @JoinColumn(name = "id_nivel", nullable = false)
    private EscolaridadesModel nivel;
}
