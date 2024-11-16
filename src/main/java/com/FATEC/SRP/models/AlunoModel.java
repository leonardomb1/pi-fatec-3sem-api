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
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Getter
@Setter
@Entity
@Table(name="Aluno")
public class AlunoModel {
    
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario")
    private UsuarioModel usuario;

    @OneToMany(mappedBy = "aluno")
    private List<AlunoTurmaModel> turmaAluno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "empresa_id", referencedColumnName = "id")
    private EmpresaModel empresa;

    @Column(name = "candidato")
    private Boolean candidato;

    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    @Column(name = "banco", nullable = false, length = 30)
    private String banco;

    @Column(name = "agencia", nullable = false, length = 30)
    private String agencia;

    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @Column(name = "rg", nullable = false, length = 12)
    private String rg;

    @Column(name = "nivel_escolaridade", nullable = false, length = 30)
    private String nivelEscolaridade;

    @Column(name = "pcd")
    private Boolean pcd;

    @Column(name = "descricao_pcd", nullable = false, length = 100)
    private String descricaoPcd;

    @Column(name = "dt_nascimento", updatable = false)
    private LocalDateTime dtNascimento;

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
