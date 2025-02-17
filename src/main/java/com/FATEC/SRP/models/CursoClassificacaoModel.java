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
 * Representa a associação entre cursos e classificações.
 * Esta classe é mapeada para a tabela "Cursos_Classificacoes" no banco de dados e mantém as informações 
 * sobre a relação entre um curso e sua respectiva classificação.
 * 
 * Conceitos OOP utilizados:
 * - **Associação**: A relação entre `CursoClassificacaoModel` e as classes `ClassificacaoModel` e `CursoModel` é de muitos para um, significando que múltiplos cursos podem ter a mesma classificação.
 * - **Encapsulamento**: A classe encapsula as propriedades da associação entre curso e classificação e oferece métodos para acessar e modificar esses valores de forma segura.
 * - **Abstração**: A classe abstrai a relação entre os cursos e as classificações, facilitando a manipulação e persistência dos dados relacionados no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Cursos_Classificacoes")
public class CursoClassificacaoModel {
    
    /**
     * Identificador único da associação entre curso e classificação. Este campo é gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * A classificação associada ao curso. Relacionamento de muitos para um com a classe `ClassificacaoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "classificacao_id", referencedColumnName = "id")
    private ClassificacaoModel classificacao;
    
    /**
     * O curso associado a uma classificação. Relacionamento de muitos para um com a classe `CursoModel`.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private CursoModel curso;
    
    /**
     * Data de cadastro da associação. Este campo não pode ser atualizado após a persistência.
     */
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    /**
     * Data da última alteração na associação. Este campo é atualizado automaticamente antes de cada atualização.
     */
    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    /**
     * Método chamado automaticamente antes da persistência de uma nova associação entre curso e classificação.
     * Atribui a data e hora atuais ao campo `dtCadastro`.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }
}
