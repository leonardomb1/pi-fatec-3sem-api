package com.fatec.srp.service;

import java.util.List;

/**
 * Interface genérica para serviços que realizam operações CRUD (Criar, Ler, Atualizar, Excluir) em entidades.
 * 
 * @param <T> O tipo da entidade que o serviço gerencia.
 * @param <ID> O tipo do identificador da entidade.
 */
public interface IService<T, ID> {

    /**
     * Recupera todos os registros da entidade.
     * 
     * @return Lista de objetos do tipo {@link T}.
     */
    public List<T> read();

    /**
     * Recupera um registro específico da entidade com base no ID.
     * 
     * @param id ID do registro a ser recuperado.
     * @return Objeto do tipo {@link T} correspondente ao ID fornecido.
     */
    public T read(ID id);

    /**
     * Atualiza um registro existente da entidade.
     * 
     * @param id ID do registro a ser atualizado.
     * @param entity Objeto com os dados atualizados.
     * @return O objeto do tipo {@link T} atualizado.
     */
    public T update(ID id, T entity);

    /**
     * Exclui um registro da entidade com base no ID.
     * 
     * @param id ID do registro a ser excluído.
     * @return O objeto do tipo {@link T} que foi excluído.
     */
    public T delete(ID id);
}
