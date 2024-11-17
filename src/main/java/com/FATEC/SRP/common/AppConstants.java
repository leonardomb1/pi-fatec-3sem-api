package com.fatec.srp.common;

/**
 * Classe final que contém constantes utilizadas no aplicativo.
 * 
 * Esta classe serve como um repositório central para constantes que são
 * compartilhadas e reutilizadas em todo o projeto. A intenção é evitar 
 * valores "hard-coded" espalhados pelo código e melhorar a legibilidade 
 * e a manutenção do projeto.
 * 
 * <p>Exemplo de uso:
 * <pre>
 * if (responseCode == AppConstants.OK) {
 *     // Lógica de resposta bem-sucedida
 * }
 * </pre>
 */
public final class AppConstants {

    /**
     * Código de resposta HTTP para sucesso (OK).
     * 
     * Representa o código HTTP 200, que indica que uma requisição foi 
     * bem-sucedida.
     */
    public static final int OK = 200;

    /**
     * Construtor privado para evitar a criação de instâncias.
     * 
     * Como esta classe é uma classe utilitária para constantes, não faz 
     * sentido permitir a criação de instâncias.
     */
    private AppConstants() {
        // Construtor vazio para evitar instanciação.
    }
}
