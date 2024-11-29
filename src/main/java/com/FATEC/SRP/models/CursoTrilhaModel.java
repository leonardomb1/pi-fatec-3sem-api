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
 * 
 * Conceitos OOP utilizados:
 * - **Composição**: A classe `CursoTrilhaModel` tem uma relação de composição com as classes `TrilhaModel` e `CursoModel`. Ela representa a dependência de um curso com uma trilha específica.
 * - **Associação**: A classe estabelece relações de muitos para um entre a associação de cursos e trilhas, permitindo que a associação tenha acesso aos dados do curso e da trilha envolvidos.
 * - **Encapsulamento**: As propriedades como `curso`, `trilha`, e `dtCadastro` são encapsuladas, garantindo que os dados sejam acessados de forma controlada.
 * - **Abstração**: A classe abstrai a lógica de relacionamento entre cursos e trilhas, oferecendo uma interface simples para interagir com a base de dados sem expor sua implementação interna.
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
    private Integer id;

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
