package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: Os campos como `nomeUsuario`, `nomePessoa`, `nomeSocial`, `senha`, entre outros, estão encapsulados, controlando o acesso e a modificação dos dados do usuário.
 * - **Abstração**: A classe abstrai os detalhes sobre os usuários do sistema, expondo apenas as informações necessárias para a operação.
 * - **Modificação de Estado**: A classe possui métodos que alteram o estado do objeto, como as datas de cadastro e alteração, que são configuradas automaticamente durante a persistência e atualização do objeto.
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @Column(name = "nome_social", nullable = true, length = 100)
    private String nomeSocial;

    
    @Column(name = "email", nullable = true, length = 50)
    private String email;

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
