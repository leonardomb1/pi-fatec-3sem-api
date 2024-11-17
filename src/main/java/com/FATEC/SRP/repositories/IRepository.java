package com.fatec.srp.repositories;

import java.util.List;

/**
 * Interface genérica para operações CRUD (Criar, Ler, Atualizar e Excluir).
 * 
 * @param <T> Tipo da entidade que será manipulada.
 * @param <ID> Tipo da chave primária da entidade.
 * 
 * Esta interface define os métodos básicos para realizar operações de persistência
 * em qualquer entidade do tipo {@link T}, onde a chave primária é do tipo {@link ID}.
 * Implementações concretas desta interface devem fornecer a lógica para persistir,
 * buscar, atualizar e excluir as entidades em um banco de dados.
 */
public interface IRepository<T, ID> {
    
    /**
     * Salva a entidade no banco de dados.
     * 
     * @param entity A entidade a ser salva.
     * @return A entidade salva.
     */
    public T save(T entity);

    /**
     * Encontra uma entidade pelo seu identificador (ID).
     * 
     * @param id O identificador único da entidade.
     * @return A entidade encontrada, ou null se não encontrada.
     */
    public T findById(ID id);

    /**
     * Atualiza os dados de uma entidade no banco de dados.
     * 
     * @param entity A entidade a ser atualizada.
     * @return A entidade atualizada.
     */
    public T update(T entity);

    /**
     * Exclui uma entidade pelo seu identificador (ID).
     * 
     * @param id O identificador único da entidade a ser excluída.
     */
    public void delete(ID id);

    /**
     * Recupera todas as entidades do tipo {@link T}.
     * 
     * @return Uma lista contendo todas as entidades.
     */
    public List<T> findAll();
}
