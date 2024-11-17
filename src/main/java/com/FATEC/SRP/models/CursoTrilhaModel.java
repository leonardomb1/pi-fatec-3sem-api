package com.fatec.srp.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Representa a associação entre cursos e trilhas no sistema. 
 * Esta classe é mapeada para a tabela "Cursos_Trilhas" no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Cursos_Trilhas")
public class CursoTrilhaModel {
    
    /**
     * Identificador único da associação entre um curso e uma trilha. 
     * Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Trilha associada ao curso. Relacionamento de muitos para um com a classe `TrilhaModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "trilha_id", referencedColumnName = "id")
    private TrilhaModel trilha;
    
    /**
     * Curso associado à trilha. Relacionamento de muitos para um com a classe `CursoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private CursoModel curso;
    
    /**
     * Data de cadastro da associação entre o curso e a trilha. Este campo não pode ser alterado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Método chamado automaticamente antes da persistência da associação entre o curso e a trilha.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }
}
