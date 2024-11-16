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
@Table(name="Empresas")
public class EmpresaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "empresa")
    private List<AlunoModel> aluno;

    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    @Column(name = "nome_fantasia", nullable = false, length = 100)
    private String nomeFantasia;
   
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    @Column(name = "banco", nullable = false, length = 30)
    private String banco;

    @Column(name = "agencia", nullable = false, length = 30)
    private String agencia;

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
