package com.fatec.srp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.annotation.PostConstruct;
/**
 * Classe principal que inicia a aplicação Spring Boot.
 * 
 * <p>Conceitos de POO utilizados:
 * <ul>
 *   <li>Encapsulamento: Atributos privados com acesso através de getters e setters.</li>
 *   <li>Abstração: Representa a aplicação Spring Boot com seus atributos e comportamentos.</li>
 *   <li>Herança: Utilização de anotações Spring para herdar comportamentos de configuração e inicialização.</li>
 * </ul>
 * </p>
 */
@SpringBootApplication(scanBasePackages = "com.fatec.*")
@EnableJpaRepositories("com.fatec.*")
@ComponentScan(basePackages = { "com.fatec*" })
@EntityScan("com.fatec.*")   
public class SrpApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     * 
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        SpringApplication.run(SrpApplication.class, args);
    }

    /**
     * Método de inicialização pós-construção.
     * 
     * <p>A anotação {@code @PostConstruct} indica que este método deve ser executado
     * para inicializar recursos ou configurar propriedades após a construção do bean.
     */
    @PostConstruct
    public void init() {
    }
}