package com.fatec.srp.repositories;

import com.fatec.srp.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link FuncionarioModel}.
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * na tabela relacionada à entidade {@link FuncionarioModel}.
 * O Spring Data JPA implementa automaticamente os métodos de persistência básicos para a entidade.
 * 
 * A interface estende {@link JpaRepository} com a entidade {@link FuncionarioModel} e o tipo de chave primária {@link Integer}.
 * Isso significa que não há necessidade de implementar explicitamente os métodos de persistência,
 * pois o Spring Data JPA cuida disso automaticamente.
 * 
 * Conceitos OOP utilizados:
 * - **Abstração**: A interface abstrai as operações de banco de dados para a entidade `FuncionarioModel`, fornecendo uma interface simplificada para manipulação dos dados, sem a necessidade de implementação manual de métodos.
 * - **Herança**: A interface `FuncionarioRepository` herda as funcionalidades do `JpaRepository`, utilizando a implementação fornecida pelo Spring Data JPA para operações CRUD.
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
}
