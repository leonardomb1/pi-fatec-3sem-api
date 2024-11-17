package com.fatec.srp.repositories;

import com.fatec.srp.models.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link CursoModel}.
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * na tabela relacionada à entidade {@link CursoModel}.
 * O Spring Data JPA implementa automaticamente os métodos de persistência básicos para a entidade.
 * 
 * A interface estende {@link JpaRepository} com a entidade {@link CursoModel} e o tipo de chave primária {@link Integer}.
 * Isso significa que não há necessidade de implementar explicitamente os métodos de persistência,
 * pois o Spring Data JPA cuida disso automaticamente.
 * 
 * Conceitos OOP utilizados:
 * - **Abstração**: A interface abstrai as operações de banco de dados para a entidade `CursoModel`, proporcionando uma interface simples para manipulação dos dados.
 * - **Herança**: A interface `CursosRepository` herda a funcionalidade de persistência do `JpaRepository`, utilizando a implementação do Spring Data JPA para CRUD sem a necessidade de código adicional.
 */
@Repository
public interface CursosRepository extends JpaRepository<CursoModel, Integer> {
}
