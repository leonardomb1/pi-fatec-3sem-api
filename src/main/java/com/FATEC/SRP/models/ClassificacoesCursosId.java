package com.fatec.srp.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassificacoesCursosId implements Serializable {
    
    private Long idCurso;
    private Long idClassificacao;

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificacoesCursosId)) return false;
        ClassificacoesCursosId that = (ClassificacoesCursosId) o;
        return Objects.equals(idCurso, that.idCurso) &&
               Objects.equals(idClassificacao, that.idClassificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idClassificacao);
    }
}
