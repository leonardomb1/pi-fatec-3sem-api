package com.fatec.srp.repositories;

import com.fatec.srp.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link TurmaModel}.
 * 
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * para a entidade {@link TurmaModel}. Ele estende a interface {@link JpaRepository},
 * que já oferece métodos prontos para essas operações básicas de persistência, como salvar, 
 * buscar por ID, atualizar, excluir e listar todas as instâncias de {@link TurmaModel}.
 * 
 * A interface {@link JpaRepository} também permite a criação de consultas personalizadas.
 */
@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Integer> {
}
