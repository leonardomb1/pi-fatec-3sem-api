package com.fatec.srp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que representa o modelo de Classificações.
 * Utiliza anotações do Lombok para gerar getters, setters, construtores e o padrão Builder.
 * Anotada como uma entidade JPA para mapeamento com a tabela "classificacoes" no banco de dados.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Abstração: Representa uma classificação com seus atributos e comportamentos.</li>
 *   <li>Herança: Utilização de anotações JPA para herdar comportamentos de persistência.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = ClassificacoesModel.TABLE_NAME)
public class ClassificacoesModel {
    static final String TABLE_NAME = "classificacoes";

    /**
     * Identificador único da classificação.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nome da classificação.
     * Não pode ser nulo.
     */
    @Column(name = "nome_classificacao", nullable = false)
    @NotBlank(message = "Nome da classificação é obrigatório")
    private String nomeClassificacao;

    /**
     * Data de cadastro da classificação.
     * Preenchida automaticamente na criação do registro.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no cadastro da classificação.
     * Atualizada automaticamente na modificação do registro.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Lista de classificações de cursos associadas a esta classificação.
     * Mapeada pelo atributo "classificacao" na entidade ClassificacoesCursosModel.
     */
    @OneToMany(mappedBy = "classificacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClassificacoesCursosModel> classificacoesCursos;

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
