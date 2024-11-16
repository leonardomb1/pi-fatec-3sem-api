package com.fatec.srp.models;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Getter
@Setter
@Entity
@Table(name="Funcionarios")
public class FuncionarioModel {
    
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario")
    private UsuarioModel usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    private CargoModel cargo;

    @OneToMany(mappedBy = "funcionario")
    private List<FuncionarioTurmaModel> funcionarioTurma;

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
