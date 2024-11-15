package com.fatec.srp.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe genérica que representa uma resposta base para as requisições da API.
 * 
 * @param <T> O tipo da mensagem que será retornada na resposta.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Generics: Permite que a classe trabalhe com qualquer tipo de dado, especificado no momento da instanciação.</li>
 * </ul>
 * </p>
 */
@Setter
@Getter
@Builder
public class ResponseBase<T> {
    /**
     * Informação adicional sobre a resposta.
     */
    private String info;
    
    /**
     * Indica se houve um erro na requisição.
     */
    private boolean error;
    
    /**
     * Código de status HTTP da resposta.
     */
    private int status;
    
    /**
     * Mensagem de resposta, cujo tipo é definido pela classe que utiliza ResponseBase.
     */
    private T message;
}