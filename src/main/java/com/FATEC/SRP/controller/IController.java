package com.fatec.srp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;


public interface IController<T, ID> {
    public ResponseEntity<ResponseBase<List<T>>> getAll();

    public ResponseEntity<ResponseBase<T>> getById(ID id);

    public ResponseEntity<ResponseBase<T>> getBody(T body);
    
    public ResponseEntity<ResponseBase<T>> update(ID id, T body);
}
