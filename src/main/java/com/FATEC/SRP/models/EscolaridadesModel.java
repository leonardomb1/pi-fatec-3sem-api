package com.fatec.srp.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe que representa o modelo de Escolaridades.
 * Utiliza anotações do Lombok para gerar getters, setters, construtores e o padrão Builder.
 * É uma entidade JPA mapeada para a tabela "escolaridades".
 * 
 * <p>Os conceitos de Programação Orientada a Objetos (POO) utilizados incluem:</p>
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Abstração: Representa uma entidade do mundo real (Escolaridades) como uma classe.</li>
 *   <li>Construtores: Construtores padrão e com argumentos gerados pelo Lombok para facilitar a criação de instâncias.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = EscolaridadesModel.TABLE_NAME)
public class EscolaridadesModel {
    static final String TABLE_NAME = "escolaridades";
    
    /**
     * Identificador único da escolaridade.
     * Gerado automaticamente pela estratégia de identidade.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nível da escolaridade.
     * Não pode ser nulo e tem um comprimento máximo de 20 caracteres.
     */
    @Column(name = "nivel", length = 20 , nullable = false)
    private String nivel;
}
