package com.fatec.srp.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Modelo de ID de Pré-Requisito que implementa Serializable.
 * Representa a chave composta para a entidade de pré-requisito.
 */

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreRequisitoIdModel implements Serializable {
    
    private Long idCurso;
    private Long idPreRequisito;

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificacoesCursosId)) return false;
        ClassificacoesCursosId that = (ClassificacoesCursosId) o;
        return Objects.equals(idCurso, that.idCurso) &&
               Objects.equals(idPreRequisito, that.idPreRequisito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idPreRequisito);
    }
}



