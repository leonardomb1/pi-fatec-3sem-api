package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que representa o modelo de Classificação.
 * Mapeia a entidade "classificacao" no banco de dados.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = ClassificacoesModel.TABLE_NAME)
public class ClassificacoesModel {
    static final String TABLE_NAME = "classificacoes";

    /**
     * Identificador único da classificação.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nome da classificação.
     * Não pode ser nulo.
     */
    @Column(name = "nome_classificacao", nullable = false)
    @NotBlank(message = "Nome da classificação é obrigatório")
    private String nomeClassificacao;

    /**
     * Data de cadastro da classificação.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro da classificação.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @OneToMany(mappedBy = "classificacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassificacoesCursosModel> classificacoesCursos;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
