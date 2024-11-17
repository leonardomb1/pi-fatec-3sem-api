package com.fatec.srp.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * Classe que representa a estrutura de uma resposta genérica para a API.
 * Contém informações sobre o status da operação, mensagem de erro e dados de resposta.
 *
 * @param <T> Tipo de dado que será incluído na mensagem de resposta.
 */
@Setter
@Getter
@Builder
public class ResponseBase<T> {
    
    /**
     * Mensagem informativa sobre o status da operação.
     */
    private String info;

    /**
     * Indica se ocorreu um erro durante a operação.
     * 
     * @return true se houver erro, caso contrário false.
     */
    private boolean error;

    /**
     * Código de status HTTP da operação realizada.
     * 
     * @return Código numérico de status, como 200 para sucesso, 404 para não encontrado, etc.
     */
    private int status;

    /**
     * Mensagem ou dados relacionados ao resultado da operação.
     * 
     * @param <T> Tipo de dado que será retornado (por exemplo, um objeto ou lista de objetos).
     * @return A mensagem de resposta ou dados relevantes da operação.
     */
    private T message;
}
