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
 * Classe que representa o identificador composto para a entidade PreRequisito.
 * Utiliza as anotações do JPA para ser embutida em outra entidade.
 * 
 * <p>Esta classe implementa a interface Serializable para permitir que seus objetos
 * sejam convertidos em uma sequência de bytes, facilitando o armazenamento e a transmissão.</p>
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Abstração: Representa uma chave composta para a entidade de pré-requisito</li>
 *   <li>Construtores: Construtores gerados automaticamente pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 *   <li>Equals e HashCode: Métodos sobrescritos para garantir a correta comparação e uso em coleções baseadas em hash.</li>
 * </ul>
 * </p>
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreRequisitoIdModel implements Serializable {
    
    /**
     * Identificador do curso.
     */
    private Long idCurso;
    
    /**
     * Identificador do pré-requisito.
     */
    private Long idPreRequisito;

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
               Objects.equals(idPreRequisito, that.idPreRequisito);
    }

    /**
     * Calcula o código hash para este objeto.
     * 
     * @return o código hash calculado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idPreRequisito);
    }
}



