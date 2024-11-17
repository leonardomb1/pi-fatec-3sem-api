package com.fatec.srp.repositories;

import com.fatec.srp.models.TrilhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link TrilhaModel}.
 * 
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * para a entidade {@link TrilhaModel}. Ele estende a interface {@link JpaRepository},
 * que já oferece métodos prontos para essas operações básicas de persistência, como salvar, 
 * buscar por ID, atualizar, excluir e listar todas as instâncias de {@link TrilhaModel}.
 * 
 * A interface {@link JpaRepository} também permite a criação de consultas personalizadas.
 * 
 * Conceitos OOP utilizados:
 * - **Abstração**: A interface proporciona uma camada de abstração para as operações de banco de dados, escondendo a implementação real dos métodos.
 * - **Herança**: A interface herda funcionalidades do {@link JpaRepository}, que implementa as operações básicas de persistência.
 */
@Repository
public interface TrilhaRepository extends JpaRepository<TrilhaModel, Integer> {
}
