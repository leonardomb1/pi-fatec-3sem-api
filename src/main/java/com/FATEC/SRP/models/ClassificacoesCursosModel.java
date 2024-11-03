package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = ClassificacoesCursosModel.TABLE_NAME)
public class ClassificacoesCursosModel {
    static final String TABLE_NAME = "classificacoes_cursos";

    @EmbeddedId
    private ClassificacoesCursosId id;

    /**
     * Data de cadastro do registro.
     * Não pode ser atualizada.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro do registro.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @ManyToOne
    @MapsId("idCurso")
    @JoinColumn(name = "id_curso", nullable = false)
    @NotNull
    private CursosModel curso;

    @ManyToOne
    @MapsId("idClassificacao")
    @JoinColumn(name = "id_classificacao", nullable = false)
    @NotNull
    private ClassificacoesModel classificacao;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}

