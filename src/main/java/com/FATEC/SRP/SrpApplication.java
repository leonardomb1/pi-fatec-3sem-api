package com.fatec.srp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.PostConstruct;

/**
 * Classe principal da aplicação Spring Boot.
 * 
 * Esta classe é anotada com '@SpringBootApplication', que marca a classe principal de uma aplicação Spring Boot.
 * O pacote base para escanear componentes Spring é definido por scanBasePackages. A anotação configura automaticamente:
 * - **Component scanning**: Scaneia todos os componentes (beans) no pacote base.
 * - **Auto-configuration**: Configura automaticamente várias funcionalidades do Spring.
 * - **Enable JPA repositories**: Habilita o uso de repositórios JPA no pacote especificado.
 * - **Entity scanning**: Configura o escaneamento de entidades JPA no pacote.
 * 
 * Conceitos OOP utilizados:
 * - **Encapsulamento**: A classe fornece uma interface pública para iniciar a aplicação sem expor detalhes internos de configuração.
 * - **Abstração**: O Spring Boot abstrai a complexidade da configuração manual de beans e a inicialização da aplicação.
 * - **Composição**: A classe é composta por várias anotações Spring que atuam em conjunto para fornecer configurações automáticas.
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
     * 
     * Conceitos OOP utilizados:
     * - **Polimorfismo**: A classe {@link SpringApplication} invoca o método {@code run} de forma polimórfica, permitindo a inicialização da aplicação.
     * 
     * @see SpringApplication
     */
    public static void main(String[] args) {
        SpringApplication.run(SrpApplication.class, args);
    }

    /**
     * Método de inicialização pós-construção.
     * 
     * Este método é executado após a construção do bean, indicado pela anotação {@link PostConstruct}.
     * Ele pode ser usado para configurar a aplicação ou inicializar recursos necessários.
     * 
     * Anotação que indica que este método deve ser executado após a construção do bean.
     * Este método imprime o nome de usuário e a senha do banco de dados no console.
     * 
     * Conceitos OOP utilizados:
     * - **Injeção de Dependência**: O Spring cuida da criação e injeção dos beans, permitindo que a lógica de inicialização seja executada após o bean ser construído.
     * - **Abstração**: O método init() abstrai a lógica de inicialização, permitindo a configuração posterior do ambiente sem expor detalhes.
     */
    @PostConstruct
    public void init() {
    }
        /**
     * Configuração de CORS para a aplicação.
     * 
     * Este método cria e retorna um bean do tipo {@link WebMvcConfigurer},
     * permitindo configurar o mapeamento de CORS diretamente na classe principal.
     * 
     * Conceitos OOP utilizados:
     * - **Injeção de Dependência**: O método registra um bean no contexto do Spring, permitindo que outros componentes usem a configuração de CORS.
     * - **Abstração**: Encapsula a lógica de configuração de CORS em um método específico.
     * - **Composição**: O bean criado é parte da composição geral da configuração do aplicativo.
     * 
     * @return Um bean configurado para gerenciar mapeamentos de CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }
}
