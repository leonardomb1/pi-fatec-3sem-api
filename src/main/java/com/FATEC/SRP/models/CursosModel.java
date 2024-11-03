package com.fatec.srp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa um modelo de curso.
 * Mapeia a entidade "cursos" no banco de dados.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = CursosModel.TABLE_NAME)
public class CursosModel {
    static final String TABLE_NAME = "cursos";

    /**
     * Identificador único do curso.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nome do curso.
     */
    @Column(name = "nome_curso", length = 80, nullable = false)
    private String nomeCurso;

    /**
     * Descrição do curso.
     */
    @Column(name = "desc_curso", length = 100)
    private String descCurso;

    /**
     * Programação do curso.
     */
    @Column(name = "programacao")
    private String programacao;

    /**
     * Data de cadastro do curso.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro do curso.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
