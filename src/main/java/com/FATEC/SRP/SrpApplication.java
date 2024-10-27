package com.FATEC.SRP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

/**
 * Classe principal da aplicação Spring Boot.
 * 
 * @SpringBootApplication: Anotação que marca a classe principal de uma aplicação Spring Boot.
 * @scanBasePackages: Define o pacote base para escanear componentes Spring.
 */
@SpringBootApplication(scanBasePackages = "com.FATEC")
public class SrpApplication {

    /**
     * Nome de usuário do banco de dados.
     * 
     * @Value: Injeta o valor da propriedade 'db.username' do arquivo de configuração.
     */
    @Value("${db.username}")
    private String dbUsername;

    /**
     * Senha do banco de dados.
     * 
     * @Value: Injeta o valor da propriedade 'db.password' do arquivo de configuração.
     */
    @Value("${db.password}")
    private String dbPassword;

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
     * @PostConstruct: Anotação que indica que este método deve ser executado após a construção do bean.
     * Este método imprime o nome de usuário e a senha do banco de dados no console.
     */
    @PostConstruct
    public void init() {
        System.out.println("DB Username: " + dbUsername);
        System.out.println("DB Password: " + dbPassword);
    }
}