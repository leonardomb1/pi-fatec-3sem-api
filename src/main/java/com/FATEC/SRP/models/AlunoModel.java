package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

/**
 * Representa um modelo de aluno, incluindo informações pessoais, acadêmicas e de registro.
 * Esta classe é mapeada para a tabela "Aluno" no banco de dados e estabelece relações com outras entidades
 * como Usuario, Empresa e AlunoTurma.
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: A classe encapsula todas as propriedades do aluno, oferecendo métodos getters e setters gerados automaticamente pela anotação Lombok.
 * - **Associação**: A classe utiliza associações de relacionamento entre entidades com anotações JPA, como @OneToOne, @ManyToOne, e @OneToMany.
 * - **Abstração**: A entidade representa um aluno de forma abstrata, ocultando a complexidade da implementação interna do banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Aluno")
public class AlunoModel {

    /**
     * Representa o usuário associado a este aluno. A relação é de um para um com a classe `UsuarioModel`.
     * O campo `nome_usuario` é usado como chave estrangeira.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioModel usuario;

    /**
     * Lista de turmas associadas a este aluno. A relação é de um para muitos com a classe `AlunoTurmaModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<AlunoTurmaModel> turmaAluno;

    /**
     * Representa a empresa associada a este aluno. A relação é de muitos para um com a classe `EmpresaModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "empresa_id", referencedColumnName = "id", nullable = true)
    private EmpresaModel empresa;

    /**
     * Indica se o aluno é candidato ou não.
     */
    @Column(name = "candidato")
    private Boolean candidato;

    /**
     * Endereço do aluno.
     */
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    /**
     * Nome do banco do aluno.
     */
    @Column(name = "banco", nullable = true, length = 30)
    private String banco;

    /**
     * Agência bancária do aluno.
     */
    @Column(name = "agencia", nullable = true, length = 30)
    private String agencia;

    /**
     * CPF do aluno.
     */
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    /**
     * RG do aluno.
     */
    @Column(name = "rg", nullable = false, length = 12)
    private String rg;

    /**
     * Nível de escolaridade do aluno.
     */
    @Column(name = "nivel_escolaridade", nullable = false, length = 30)
    private String nivelEscolaridade;
    
    /**
     * CEP do aluno
     */
    @Column(name = "cep", nullable = false, length = 14)
    private String cep;

    @Column(name = "nome_pai", nullable = false, length = 50)
    private String nomePai;

    @Column(name = "nome_mae", nullable = false, length = 50)
    private String nomeMae;

    @Column(name = "nome_responsavel", nullable = true, length = 50)
    private String nomeResponsavel;

    /**
     * Indica se o aluno possui alguma deficiência.
     */
    @Column(name = "pcd")
    private Boolean pcd;

    /**
     * Descrição da deficiência do aluno (caso tenha).
     */
    @Column(name = "descricao_pcd", nullable = false, length = 100)
    private String descricaoPcd;

    /**
     * Data de nascimento do aluno. O campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_nascimento", updatable = false)
    private LocalDateTime dtNascimento;

    /**
     * Data de cadastro do aluno. A data é atribuída automaticamente antes da persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração nos dados do aluno. A data é atribuída automaticamente antes da atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo registro de aluno.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização de um registro existente.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
