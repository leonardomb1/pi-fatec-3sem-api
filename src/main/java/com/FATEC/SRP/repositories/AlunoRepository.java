package com.fatec.srp.repositories;

import com.fatec.srp.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link AlunoModel}.
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * na tabela relacionada à entidade {@link AlunoModel}.
 * O Spring Data JPA fornece implementações automáticas para os métodos básicos de persistência de dados.
 * 
 * A interface estende {@link JpaRepository} com a entidade {@link AlunoModel} e o tipo de chave primária {@link Integer}.
 * Não é necessário implementar explicitamente os métodos de persistência, pois o Spring Data JPA faz isso automaticamente.
 */
@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {
}
