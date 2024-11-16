package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name="Cursos")
public class CursoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "curso")
    private List<TurmaModel> turma;

    @OneToMany(mappedBy = "curso")
    private List<CursoClassificacaoModel> cursoClassificacao;

    @OneToMany(mappedBy = "curso")
    private List<PreRequisitoCursoModel> cursoRequisito;

    @OneToMany(mappedBy = "curso")
    private List<CursoTrilhaModel> cursoTrilha;

    @Column(name = "nome_curso", nullable = false, length = 40)
    private String nomeCurso;

    @Column(name = "desc_curso", nullable = false, length = 255)
    private String descCurso;

    @Column(name = "programacao", nullable = false, length = 255)
    private String programacao;

    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

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
