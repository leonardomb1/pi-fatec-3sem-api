package com.fatec.srp.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa a estrutura de uma resposta genérica para a API.
 * Contém informações sobre o status da operação, mensagem de erro e dados de resposta.
 *
 * @param <T> Tipo de dado que será incluído na mensagem de resposta.
 * 
 * Conceitos de OOP:
 * - **Generics**: A classe é genérica, utilizando o parâmetro de tipo `T`, permitindo que qualquer tipo de dado seja incluído na mensagem de resposta, proporcionando flexibilidade e reutilização do código.
 * - **Encapsulamento**: A classe encapsula todas as informações necessárias para representar uma resposta de API, como status, erro, e dados. Ela oculta a complexidade dos detalhes de resposta e fornece uma interface simples.
 * - **Builder Pattern**: Usando o padrão de design *Builder*, a classe permite a criação flexível de objetos complexos de forma fluida, sem a necessidade de definir um construtor com muitos parâmetros.
 */
@Setter
@Getter
@Builder
public class ResponseBase<T> {
    
    private String info;

    private boolean error;

    private int status;

    private T message;
}
