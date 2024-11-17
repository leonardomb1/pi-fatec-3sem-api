package com.fatec.srp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;


/**
 * Interface genérica que define as operações básicas de um controlador para uma entidade.
 * 
 * @param <T> Tipo da entidade que o controlador gerencia.
 * @param <ID> Tipo do identificador único da entidade.
 */
public interface IController<T, ID> {

    /**
     * Recupera todos os registros da entidade gerenciada.
     * 
     * @return ResponseEntity contendo uma lista de entidades ou uma resposta de erro.
     */
    public ResponseEntity<ResponseBase<List<T>>> getAll();

    /**
     * Recupera um registro específico da entidade com base no identificador fornecido.
     * 
     * @param id Identificador único do registro.
     * @return ResponseEntity contendo o registro encontrado ou uma resposta de erro.
     */
    public ResponseEntity<ResponseBase<T>> getById(ID id);

    /**
     * Cria um novo registro da entidade com base nos dados fornecidos.
     * 
     * @param body Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro criado ou uma resposta de erro.
     */
    public ResponseEntity<ResponseBase<T>> getBody(T body);

    /**
     * Atualiza um registro existente da entidade com base no identificador e nos dados fornecidos.
     * 
     * @param id Identificador único do registro a ser atualizado.
     * @param body Objeto contendo os dados atualizados do registro.
     * @return ResponseEntity contendo o registro atualizado ou uma resposta de erro.
     */
    public ResponseEntity<ResponseBase<T>> update(ID id, T body);
}
