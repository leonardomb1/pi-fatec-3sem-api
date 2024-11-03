package com.fatec.srp.repositories;

import com.fatec.srp.models.CargosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargosRepository extends JpaRepository<CargosModel, Integer> {
}