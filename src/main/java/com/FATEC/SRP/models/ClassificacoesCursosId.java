package com.fatec.srp.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa a chave composta para a entidade ClassificacoesCursos.
 * Utiliza as anotações do Lombok para gerar automaticamente os métodos 
 * getters, setters, construtores e o padrão de projeto Builder.
 * 
 * <p>Esta classe implementa Serializable para permitir que suas instâncias 
 * sejam serializadas e desserializadas, o que é necessário para chaves compostas 
 * em JPA.</p>
 * 
 * <p>Os conceitos de Programação Orientada a Objetos (POO) utilizados incluem:</p>
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Abstração: Representa uma chave composta para a entidade de classificação de cursos.</li>
 *   <li>Construtores: Construtores padrão e com argumentos gerados pelo Lombok para facilitar a criação de instâncias.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 *   <li>Equals e HashCode: Métodos sobrescritos para garantir a correta comparação e uso em coleções baseadas em hash.</li>
 * </ul>
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassificacoesCursosId implements Serializable {
    /**
     * @param idCurso Identificador do curso.
     * @param idClassificacao Identificador da classificação.
     */
    private Long idCurso;
    private Long idClassificacao;

    /**
     * Compara este objeto com outro para verificar se são iguais.
     * 
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificacoesCursosId)) return false;
        ClassificacoesCursosId that = (ClassificacoesCursosId) o;
        return Objects.equals(idCurso, that.idCurso) &&
               Objects.equals(idClassificacao, that.idClassificacao);
    }

    /**
     * Retorna um valor de hash para o objeto.
     * 
     * @return um valor de hash para o objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idClassificacao);
    }
}
