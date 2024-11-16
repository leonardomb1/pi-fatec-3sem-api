package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;


@Getter
@Setter
@Entity
@Table(name="Usuario")
public class UsuarioModel {

    @Id
    @Column(name = "nome_usuario", nullable = false, length = 20)
    private String nomeUsuario;

    @Column(name = "nome_pessoa", nullable = false, length = 100)
    private String nomePessoa;

    @Column(name = "nome_social", nullable = false, length = 100)
    private String nomeSocial;

    @Column(name = "senha", nullable = false)
    private String senha;

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
