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

/**
 * Representa uma empresa no sistema. Esta classe é mapeada para a tabela "Empresas" no banco de dados.
 * Contém informações sobre a empresa, como razão social, nome fantasia, CNPJ, e dados bancários, 
 * além de um relacionamento com os alunos associados a ela.
 * 
 * Conceitos OOP utilizados:
 * - **Composição**: A classe `EmpresaModel` possui uma lista de objetos `AlunoModel`, representando a relação de composição entre empresa e alunos.
 * - **Associação**: A classe estabelece uma relação de um para muitos entre `EmpresaModel` e `AlunoModel`, permitindo que a empresa esteja associada a vários alunos.
 * - **Encapsulamento**: Os campos como `razaoSocial`, `cnpj`, e `endereco` são encapsulados, permitindo o controle sobre como esses dados são acessados e modificados.
 * - **Abstração**: A classe abstrai a representação dos dados de uma empresa, incluindo dados fiscais e bancários, de forma que esses dados possam ser manipulados sem expor diretamente sua implementação interna.
 */
@Getter
@Setter
@Entity
@Table(name="Empresas")
public class EmpresaModel {
    
    /**
     * Identificador único da empresa. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Lista de alunos associados à empresa. Relacionamento de um para muitos com a classe `AlunoModel`.
     */
    @OneToMany(mappedBy = "empresa")
    private List<AlunoModel> aluno;

    /**
     * Razão social da empresa, representando o nome jurídico. Este campo não pode ser nulo e tem comprimento máximo de 100 caracteres.
     */
    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;

    /**
     * Nome fantasia da empresa, utilizado para fins comerciais. Este campo não pode ser nulo e tem comprimento máximo de 100 caracteres.
     */
    @Column(name = "nome_fantasia", nullable = false, length = 100)
    private String nomeFantasia;
   
    /**
     * CNPJ da empresa, utilizado para identificação fiscal. Este campo não pode ser nulo e tem comprimento máximo de 18 caracteres.
     */
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    /**
     * Endereço da empresa. Este campo não pode ser nulo e tem comprimento máximo de 100 caracteres.
     */
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    /**
     * Banco onde a empresa mantém sua conta bancária. Este campo não pode ser nulo e tem comprimento máximo de 30 caracteres.
     */
    @Column(name = "banco", nullable = false, length = 30)
    private String banco;

    /**
     * Agência bancária da empresa. Este campo não pode ser nulo e tem comprimento máximo de 30 caracteres.
     */
    @Column(name = "agencia", nullable = false, length = 30)
    private String agencia;

    /**
     * Data de cadastro da empresa. Este campo não pode ser alterado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração dos dados da empresa.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência da empresa.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização dos dados da empresa.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
