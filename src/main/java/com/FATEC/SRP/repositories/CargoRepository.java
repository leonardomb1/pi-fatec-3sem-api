package com.fatec.srp.repositories;

import com.fatec.srp.models.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link CargoModel}.
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * na tabela relacionada à entidade {@link CargoModel}.
 * O Spring Data JPA implementa automaticamente os métodos de persistência básicos para a entidade.
 * 
 * A interface estende {@link JpaRepository} com a entidade {@link CargoModel} e o tipo de chave primária {@link Integer}.
 * Isso significa que não há necessidade de implementar explicitamente os métodos de persistência,
 * pois o Spring Data JPA cuida disso automaticamente.
 * 
 * Conceitos OOP utilizados:
 * - **Abstração**: A interface abstrai as operações de banco de dados para a entidade `CargoModel`, fornecendo uma interface simples para persistência e recuperação de dados.
 * - **Herança**: A interface `CargoRepository` herda os métodos de persistência da interface `JpaRepository`, reutilizando a implementação de operações CRUD oferecida pelo Spring Data JPA.
 */
@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Integer> {
}
