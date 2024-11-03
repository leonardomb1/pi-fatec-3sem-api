package com.fatec.srp.service;

import java.util.List;

public interface IService<T, ID> {
    public List<T> read();

    public T read(ID id);

    public T update(ID id, T entity);

    public T delete(ID id);
}
