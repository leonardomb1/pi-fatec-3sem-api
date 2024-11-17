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

/**
 * Representa um usuário no sistema. Cada usuário tem um nome de usuário, nome completo, nome social, senha,
 * e informações sobre quando foi cadastrado ou alterado no sistema.
 * Esta classe é mapeada para a tabela "Usuario" no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Usuario")
public class UsuarioModel {

    /**
     * Nome de usuário único no sistema.
     */
    @Id
    @Column(name = "nome_usuario", nullable = false, length = 20)
    private String nomeUsuario;

    /**
     * Nome completo da pessoa associada ao usuário.
     */
    @Column(name = "nome_pessoa", nullable = false, length = 100)
    private String nomePessoa;

    /**
     * Nome social do usuário, utilizado para chamadas informais ou preferenciais.
     */
    @Column(name = "nome_social", nullable = false, length = 100)
    private String nomeSocial;

    /**
     * Senha do usuário, necessária para autenticação.
     */
    @Column(name = "senha", nullable = false)
    private String senha;

    /**
     * Data e hora de cadastro do usuário no sistema. Este campo é preenchido automaticamente durante a criação.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data e hora da última alteração no registro do usuário. Este campo é preenchido automaticamente durante a atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado antes de persistir o objeto, definindo a data de cadastro.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado antes de atualizar o objeto, definindo a data da última alteração.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
