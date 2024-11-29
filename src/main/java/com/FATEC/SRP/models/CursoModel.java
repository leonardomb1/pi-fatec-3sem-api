package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * Representa um curso na aplicação. 
 * Esta classe é mapeada para a tabela "Cursos" no banco de dados e mantém as informações sobre um curso,
 * incluindo suas turmas, classificações, requisitos e trilhas associadas.
 * 
 * Conceitos OOP utilizados:
 * - **Composição**: A classe `CursoModel` possui uma relação de composição com outras entidades como `TurmaModel`, `CursoClassificacaoModel`, `PreRequisitoCursoModel`, e `CursoTrilhaModel`, que representam diferentes aspectos de um curso.
 * - **Associação**: A classe estabelece relações de um para muitos com as outras entidades, representando a dependência e interatividade entre um curso e seus componentes.
 * - **Encapsulamento**: As propriedades dos cursos, como nome, descrição, e datas, são encapsuladas, fornecendo acesso controlado e protegido aos dados.
 * - **Abstração**: A classe abstrai os detalhes do banco de dados, permitindo que um curso seja manipulado de maneira intuitiva no código, sem necessidade de lidar diretamente com a persistência de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Cursos")
public class CursoModel {
    
    /**
     * Identificador único do curso. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Lista de turmas associadas a este curso. Relacionamento de um para muitos com a classe `TurmaModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<TurmaModel> turma;

    /**
     * Lista de classificações associadas a este curso. Relacionamento de um para muitos com a classe `CursoClassificacaoModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<CursoClassificacaoModel> cursoClassificacao;

    /**
     * Lista de pré-requisitos associadas a este curso. Relacionamento de um para muitos com a classe `PreRequisitoCursoModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<PreRequisitoCursoModel> cursoRequisito;

    /**
     * Lista de trilhas associadas a este curso. Relacionamento de um para muitos com a classe `CursoTrilhaModel`.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<CursoTrilhaModel> cursoTrilha;

    /**
     * Nome do curso. Este campo é obrigatório e possui um limite de 40 caracteres.
     */
    @Column(name = "nome_curso", nullable = false, length = 40)
    private String nomeCurso;

    /**
     * Descrição do curso. Este campo é obrigatório e possui um limite de 255 caracteres.
     */
    @Column(name = "desc_curso", nullable = false, length = 255)
    private String descCurso;

    /**
     * Programação do curso. Este campo é obrigatório e possui um limite de 255 caracteres.
     */
    @Column(name = "valor_curso", nullable = true, length = 255)
    private Float valorCurso;
    
    @Column(name = "carga_horaria", nullable = true, length = 255)
    private String cargaHoraria;
    
    @Column(name = "requisitos", nullable = true, length = 255)
    private String requisitos;

    @Column(name = "programacao", nullable = false, length = 255)
    private String programacao;

    /**
     * Data de cadastro do curso. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração no curso. Este campo é atualizado automaticamente antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de um novo curso.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método chamado automaticamente antes de cada atualização de um curso.
     * Atribui a data e hora atuais ao campo `dtAlteracao`.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
