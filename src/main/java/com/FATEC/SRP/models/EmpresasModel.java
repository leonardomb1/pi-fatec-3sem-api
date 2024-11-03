package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa uma entidade Empresa no sistema.
 * Mapeia a tabela "empresas" no banco de dados.
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
     * Campo obrigatório.
     */
    @Column(name = "razao_social", nullable = false)
    @NotBlank(message = "Razão social é obrigatória")
    private String razaoSocial;

    /**
     * Nome fantasia da empresa.
     * Campo opcional.
     */
    @Column(name = "nome_fantasia", nullable = true)
    private String nomeFantasia;

    /**
     * CNPJ da empresa.
     * Campo obrigatório.
     */
    @Column(name = "cnpj", nullable = false, length = 14, unique = true)
    @NotBlank(message = "CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "CNPJ deve ter 14 dígitos")
    private String cnpj;

    /**
     * Endereço da empresa.
     * Campo obrigatório.
     */
    @Column(name = "endereco", nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    /**
     * Banco da empresa.
     * Campo obrigatório.
     */
    @Column(name = "banco", nullable = false)
    @NotBlank(message = "Banco é obrigatório")
    private String banco;

    /**
     * Agência bancária da empresa.
     * Campo obrigatório.
     */
    @Column(name = "agencia", nullable = false)
    @NotBlank(message = "Agência é obrigatória")
    private String agencia;

    @PrePersist
    protected void onCreate() {
        super.onCreate();
    }

    @PreUpdate
    protected void onUpdate() {
        super.onUpdate();
    }
}
