package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa uma pessoa.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = PessoasModel.TABLE_NAME)
public class PessoasModel {
    public interface CriarPessoa {}
    public interface AtualizarPessoa {}
    static final String TABLE_NAME = "pessoas";

    /**
     * Identificador único da pessoa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nome da pessoa.
     */
    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome_pessoa", length = 100, nullable = false)
    @Size(min = 5, max = 100)
    private String nomePessoa;

    /**
     * Nome social da pessoa.
     */
    @Column(name = "nome_social", length = 100)
    private String nomeSocial;

    /**
     * Cadastro geral de pessoa.
     */
    @NotBlank(message = "CGP é obrigatório")
    @Column(name = "cgp_pessoa", length = 14, nullable = false, unique = true)
    @Size(min = 8, max = 14, message = "CGP deve ter entre 8 e 14 dígitos")
    private String cgpPessoa;
    
    /**
     * RG da pessoa.
     */
    @NotBlank(message = "RG é obrigatório")
    @Column(name = "rg_pessoa", length = 11, unique = true, nullable = false)
    @Size(min = 11, max = 11, message = "RG deve ter 11 dígitos")
    private String rgPessoa;

    /**
     * RNE da pessoa.
     */
    @Column(name = "rne_pessoa", length = 8)
    @Size(min = 8, max = 8, message = "RNE deve ter 8 dígitos")
    private String rnePessoa;
 
    /**
     * Email da pessoa.
     */
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    @Size(min = 3, max = 100, message = "Email deve ter entre 3 e 100 caracteres")
    private String email;

    /**
     * Celular da pessoa.
     */
    @NotBlank(message = "Celular é obrigatório")
    @Column(name = "celular", length = 10, nullable = false)
    @Pattern(regexp = "\\d{10}", message = "Celular deve conter apenas 10 dígitos")
    private String celular;

    /**
     * Telefone da pessoa.
     */

    @Column(name = "telefone", length = 11)
    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter apenas 11 dígitos")
    private String telefone;

    /**
     * Data de nascimento da pessoa.
     */
    @NotNull(message = "Data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;

    /**
     * Endereço da pessoa.
     */
    @NotBlank(message = "Endereço é obrigatório")
    @Column(name = "endereco", length = 150, nullable = false)
    @Size(min = 5, max = 150, message = "Endereço deve ter entre 5 e 150 caracteres")
    private String endereco;

    /**
     * Nome de usuário da pessoa.
     */
    @NotBlank(groups = CriarPessoa.class, message = "Nome de usuário é obrigatório")
    @Column(name = "nome_usuario", length = 50, nullable = false, unique = true, updatable = false)
    @Size(groups = CriarPessoa.class, min = 5, max = 50, message = "Nome de usuário deve ter entre 5 e 50 caracteres")
    private String nomeUsuario;

    /**
     * Senha do usuário.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(groups = {CriarPessoa.class, AtualizarPessoa.class}, message = "Senha é obrigatória")
    @Column(name = "senha_usuario", length = 100, nullable = false)
    @Size(groups = {CriarPessoa.class, AtualizarPessoa.class}, min = 8, max = 100, message = "Senha deve ter entre 8 e 100 caracteres")
    private String senhaUsuario;
    
    

    /**
     * Data de cadastro da pessoa.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro da pessoa.
     */
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
