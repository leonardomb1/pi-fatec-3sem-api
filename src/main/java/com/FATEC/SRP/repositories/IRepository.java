package com.fatec.srp.repositories;

import java.util.List;

/**
 * Interface genérica para operações CRUD (Create, Read, Update, Delete).
 * 
 * @param <T>  O tipo da entidade que será manipulada.
 * @param <ID> O tipo do identificador único da entidade.
 * 
 * Esta interface utiliza conceitos de Programação Orientada a Objetos (POO) como:
 * - Generics: para permitir que a interface trabalhe com qualquer tipo de entidade.
 * - Abstração: para definir um contrato que deve ser implementado por classes concretas.
 */
public interface IRepository<T, ID> {

    /**
     * Salva uma entidade.
     * 
     * @param entity A entidade a ser salva.
     * @return A entidade salva.
     */
    public T save(T entity);

    /**
     * Encontra uma entidade pelo seu identificador.
     * 
     * @param id O identificador da entidade.
     * @return A entidade encontrada ou null se não for encontrada.
     */
    public T findById(ID id);

    /**
     * Atualiza uma entidade.
     * 
     * @param entity A entidade a ser atualizada.
     * @return A entidade atualizada.
     */
    public T update(T entity);

    /**
     * Deleta uma entidade pelo seu identificador.
     * 
     * @param id O identificador da entidade a ser deletada.
     */
    public void delete(ID id);

    /**
     * Encontra todas as entidades.
     * 
     * @return Uma lista de todas as entidades.
     */
    public List<T> findAll();
}
