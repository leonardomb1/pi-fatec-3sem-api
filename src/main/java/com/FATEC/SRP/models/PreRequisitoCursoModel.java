package com.fatec.srp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa a associação entre um curso e seus pré-requisitos. Esta classe é mapeada para a tabela "prerequisito_curso" no banco de dados.
 * Contém informações sobre os cursos e os pré-requisitos necessários para a realização dos cursos.
 */
@Getter
@Setter
@Entity
@Table(name="prerequisito_curso")
public class PreRequisitoCursoModel {
    
    /**
     * Identificador único da associação entre o pré-requisito e o curso.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Pré-requisito associado ao curso. Relacionamento de muitos para um com a classe `PreRequisitoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "preRequisito_id", referencedColumnName = "id")
    private PreRequisitoModel preRequisito;
    
    /**
     * Curso ao qual o pré-requisito está associado. Relacionamento de muitos para um com a classe `CursoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private CursoModel curso;
}
