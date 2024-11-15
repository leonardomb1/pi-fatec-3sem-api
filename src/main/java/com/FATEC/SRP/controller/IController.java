package com.fatec.srp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;


/**
 * Interface IController que define operações CRUD básicas para um tipo genérico T e um identificador ID.
 * Utiliza conceitos de Programação Orientada a Objetos (POO) como Generics e Interfaces.
 *
 * @param <T>  O tipo da entidade que será manipulada pelo controlador.
 * @param <ID> O tipo do identificador único da entidade.
 */
public interface IController<T, ID> {

    /**
     * Recupera todas as entidades do tipo T.
     *
     * @return ResponseEntity contendo uma ResponseBase com uma lista de todas as entidades do tipo T.
     */
    public ResponseEntity<ResponseBase<List<T>>> getAll();

    /**
     * Recupera uma entidade do tipo T pelo seu identificador único.
     *
     * @param id O identificador único da entidade.
     * @return ResponseEntity contendo uma ResponseBase com a entidade do tipo T.
     */
    public ResponseEntity<ResponseBase<T>> getById(ID id);

    /**
     * Recupera uma entidade do tipo T a partir do corpo da requisição.
     *
     * @param body O corpo da requisição contendo a entidade do tipo T.
     * @return ResponseEntity contendo uma ResponseBase com a entidade do tipo T.
     */
    public ResponseEntity<ResponseBase<T>> getBody(T body);

    /**
     * Atualiza uma entidade do tipo T com base no seu identificador único e no corpo da requisição.
     *
     * @param id   O identificador único da entidade.
     * @param body O corpo da requisição contendo a entidade do tipo T atualizada.
     * @return ResponseEntity contendo uma ResponseBase com a entidade do tipo T atualizada.
     */
    public ResponseEntity<ResponseBase<T>> update(ID id, T body);
}
