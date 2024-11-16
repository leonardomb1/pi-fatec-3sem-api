package com.fatec.srp.repositories;

import com.fatec.srp.models.CursoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<CursoModel, Integer> {
}