package com.fatec.srp.repositories;

import com.fatec.srp.models.CargosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CargosRepository que estende JpaRepository para fornecer operações CRUD para a entidade CargosModel.
 * 
 * <p>Esta interface utiliza o conceito de herança da Programação Orientada a Objetos (POO), onde herda métodos
 * padrão de JpaRepository para manipulação de dados.</p>
 * 
 * @param <CargosModel> a entidade que será manipulada pelo repositório.
 * @param <Integer> o tipo do identificador da entidade.
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface CargosRepository extends JpaRepository<CargosModel, Integer> {
}