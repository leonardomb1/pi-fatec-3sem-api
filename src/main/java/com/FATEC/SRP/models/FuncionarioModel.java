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

/**
 * Representa um funcionário no sistema. Esta classe é mapeada para a tabela "Funcionarios" no banco de dados.
 * Contém informações sobre o usuário associado, cargo, e as turmas em que o funcionário está envolvido.
 * 
 * Conceitos OOP utilizados:
 * - **Composição**: A classe `FuncionarioModel` possui uma associação com as classes `UsuarioModel` (um para um), `CargoModel` (muitos para um) e `FuncionarioTurmaModel` (um para muitos), representando a relação de composição entre os objetos.
 * - **Associação**: A classe estabelece uma relação de um para um com `UsuarioModel`, muitos para um com `CargoModel`, e um para muitos com `FuncionarioTurmaModel`.
 * - **Encapsulamento**: Os campos como `usuario`, `cargo`, e `funcionarioTurma` são encapsulados, controlando como os dados são acessados e manipulados.
 * - **Abstração**: A classe abstrai a funcionalidade relacionada ao funcionário no sistema, encapsulando a lógica relacionada a dados de usuários, cargos e turmas, sem expor diretamente sua implementação interna.
 */
@Getter
@Setter
@Entity
@Table(name="Funcionarios")
public class FuncionarioModel {
    
    /**
     * Usuário associado ao funcionário. Relacionamento de um para um com a classe `UsuarioModel`.
     */
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario")
    private UsuarioModel usuario;

    /**
     * Cargo do funcionário. Relacionamento de muitos para um com a classe `CargoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    private CargoModel cargo;

    /**
     * Lista de turmas associadas ao funcionário. Relacionamento de um para muitos com a classe `FuncionarioTurmaModel`.
     */
    @OneToMany(mappedBy = "funcionario")
    private List<FuncionarioTurmaModel> funcionarioTurma;

    /**
     * Data de cadastro do funcionário. Este campo não pode ser alterado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração dos dados do funcionário.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência do funcionário.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes da atualização dos dados do funcionário.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
