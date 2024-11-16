package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name="funcionario_turmas")
public class FuncionarioTurmaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "funcionario_id", referencedColumnName = "nome_usuario")
    private FuncionarioModel funcionario; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "turma_id", referencedColumnName = "id")
    private TurmaModel turma;

    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;


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
