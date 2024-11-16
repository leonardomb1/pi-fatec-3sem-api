package com.fatec.srp.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name="Turmas")
public class TurmaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    private CursoModel curso;

    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Column(name = "periodo", nullable = false, length = 15)
    private String periodo;

    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    @OneToMany(mappedBy = "turma")
    private List<FuncionarioTurmaModel> funcionarioTurma;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @OneToMany(mappedBy = "turma")
    private List<AlunoTurmaModel> alunoTurma;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}   
