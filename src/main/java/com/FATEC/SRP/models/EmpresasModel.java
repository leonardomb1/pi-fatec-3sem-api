package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe EmpresasModel que representa uma entidade de empresa no sistema.
 * Esta classe herda de PessoasModel e utiliza anotações JPA para mapeamento
 * de banco de dados e validações.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Herança: EmpresasModel herda de PessoasModel.</li>
 *   <li>Encapsulamento: Uso de getters e setters para acessar os atributos privados.</li>
 * </ul>
 * </p>
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = EmpresasModel.TABLE_NAME)
public class EmpresasModel extends PessoasModel {
    static final String TABLE_NAME = "empresas";

    /**
     * Razão social da empresa.
     * 
     * @param razaoSocial não pode ser nulo ou vazio.
     */
    @Column(name = "razao_social", nullable = false)
    @NotBlank(message = "Razão social é obrigatória")
    private String razaoSocial;

    /**
     * Nome fantasia da empresa.
     * 
     * @param nomeFantasia pode ser nulo.
     */
    @Column(name = "nome_fantasia", nullable = true)
    private String nomeFantasia;

    /**
     * CNPJ da empresa.
     * 
     * @param cnpj deve ter exatamente 14 dígitos, não pode ser nulo ou vazio, e deve ser único.
     */
    @Column(name = "cnpj", nullable = false, length = 14, unique = true)
    @NotBlank(message = "CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "CNPJ deve ter 14 dígitos")
    private String cnpj;

    /**
     * Endereço da empresa.
     * 
     * @param endereco não pode ser nulo ou vazio.
     */
    @Column(name = "endereco", nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    /**
     * Banco da empresa.
     * 
     * @param banco não pode ser nulo ou vazio.
     */
    @Column(name = "banco", nullable = false)
    @NotBlank(message = "Banco é obrigatório")
    private String banco;

    /**
     * Agência bancária da empresa.
     * 
     * @param agencia não pode ser nulo ou vazio.
     */
    @Column(name = "agencia", nullable = false)
    @NotBlank(message = "Agência é obrigatória")
    private String agencia;

    /**
     * Método executado antes de persistir um novo registro.
     * Define a data de cadastro como a data e hora atual.
     * 
     * @PrePersist Indica que o método deve ser executado antes de persistir o registro.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método executado antes de atualizar um registro existente.
     * Define a data de alteração como a data e hora atual.
     * 
     * @PreUpdate Indica que o método deve ser executado antes de atualizar o registro.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
