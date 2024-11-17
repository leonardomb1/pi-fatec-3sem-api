package com.fatec.srp.service;

import java.util.List;

/**
 * Interface genérica para serviços que realizam operações CRUD (Criar, Ler, Atualizar, Excluir) em entidades.
 * 
 * @param <T> O tipo da entidade que o serviço gerencia.
 * @param <ID> O tipo do identificador da entidade.
 * 
 * Conceitos OOP utilizados:
 * - **Generics**: Permite que a interface seja utilizada de forma flexível com diferentes tipos de entidades e seus respectivos identificadores, sem a necessidade de reescrever o código para cada tipo específico.
 * - **Abstração**: Define um contrato genérico para as operações CRUD, permitindo que as implementações específicas sejam feitas em classes que implementam a interface.
 */
public interface IService<T, ID> {

    /**
     * Recupera todos os registros da entidade.
     * 
     * @return Lista de objetos do tipo {@link T}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: O método define o comportamento de leitura dos registros sem se preocupar com os detalhes da implementação.
     */
    public List<T> read();

    /**
     * Recupera um registro específico da entidade com base no ID.
     * 
     * @param id ID do registro a ser recuperado.
     * @return Objeto do tipo {@link T} correspondente ao ID fornecido.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: O método define o comportamento de leitura de um único registro, deixando os detalhes de implementação da busca do registro para as classes que implementam a interface.
     */
    public T read(ID id);

    /**
     * Atualiza um registro existente da entidade.
     * 
     * @param id ID do registro a ser atualizado.
     * @param entity Objeto com os dados atualizados.
     * @return O objeto do tipo {@link T} atualizado.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O método encapsula o processo de atualização de um registro, onde os detalhes de como a atualização é feita ficam ocultos.
     * - **Abstração**: O comportamento de atualizar um registro é abstraído na interface, permitindo diferentes implementações.
     */
    public T update(ID id, T entity);

    /**
     * Exclui um registro da entidade com base no ID.
     * 
     * @param id ID do registro a ser excluído.
     * @return O objeto do tipo {@link T} que foi excluído.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão é encapsulado e escondido dentro do método, permitindo que a implementação da exclusão seja alterada sem afetar outras partes do código.
     * - **Abstração**: A exclusão é representada como uma operação abstrata, permitindo diferentes implementações de exclusão.
     */
    public T delete(ID id);
}
