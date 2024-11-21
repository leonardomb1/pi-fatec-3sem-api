package com.fatec.srp.repositories;

import com.fatec.srp.models.PreRequisitoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade {@link PreRequisitoModel}.
 * 
 * Este repositório fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar e Excluir)
 * para a entidade {@link PreRequisitoModel}. Ele estende a interface {@link JpaRepository},
 * que já fornece métodos prontos para essas operações básicas de persistência, como salvar, 
 * buscar por ID, atualizar, excluir e listar todas as instâncias de {@link PreRequisitoModel}.
 * 
 * A interface {@link JpaRepository} também permite a criação de consultas personalizadas.
 * 
 * Conceitos OOP utilizados:
 * - **Abstração**: A interface esconde a complexidade das operações de banco de dados, fornecendo métodos simples de persistência para a entidade.
 * - **Herança**: A interface herda funcionalidades do {@link JpaRepository}, que é uma implementação da interface de repositório do Spring Data, fornecendo métodos prontos para usar.
 */
@Repository
public interface PreRequisitoRepository extends JpaRepository<PreRequisitoModel, Integer> {
}
