package com.fatec.srp.repositories;

import java.util.List;

public interface IRepository<T, ID> {
    public T save(T entity);

    public T findById(ID id);

    public T update(T entity);

    public void delete(ID id);

    public List<T> findAll();
}
