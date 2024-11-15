package com.fatec.srp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que representa o modelo de Cursos.
 * Utiliza anotações do JPA para mapeamento objeto-relacional.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Herança: Utilização de anotações JPA para herdar comportamentos de persistência.</li>
 *   <li>Associação: Relacionamento entre CursosModel e ClassificacoesCursosModel.</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto Builder para facilitar a criação de instâncias da classe.</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = CursosModel.TABLE_NAME)
public class CursosModel {

    static final String TABLE_NAME = "cursos";

    /**
     * Identificador único do curso.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nome do curso.
     * Não pode ser nulo e tem um limite de 80 caracteres.
     */
    @Column(name = "nome_curso", length = 80, nullable = false)
    private String nomeCurso;

    /**
     * Descrição do curso.
     * Tem um limite de 100 caracteres.
     */
    @Column(name = "desc_curso", length = 100)
    private String descCurso;

    /**
     * Programação do curso.
     */
    @Column(name = "programacao")
    private String programacao;

    /**
     * Data de cadastro do curso.
     * Não pode ser atualizada após a inserção.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração do curso.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Lista de classificações associadas ao curso.
     * Relacionamento um-para-muitos.
     */
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
