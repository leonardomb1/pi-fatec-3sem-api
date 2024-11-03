package com.fatec.srp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.annotation.PostConstruct;

/**
 * Classe principal da aplicação Spring Boot.
 * 
 * Esta classe é anotada com '@SpringBootApplication, que marca a classe principal de uma aplicação Spring Boot.
 * O pacote base para escanear componentes Spring é definido por scanBasePackages.
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
     * * @PostConstruct: Anotação que indica que este método deve ser executado após a construção do bean.
     * Este método imprime o nome de usuário e a senha do banco de dados no console.
     */
    @PostConstruct
    public void init() {
    }
}