package com.FATEC.SRP.model;

import java.io.Serializable;
import java.util.Objects;

public class ClassificacaoCursoIdModel implements Serializable {
    private Integer idClassificacao;
    private Integer idCurso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassificacaoCursoIdModel)) return false;
        ClassificacaoCursoIdModel that = (ClassificacaoCursoIdModel) o;
        return Objects.equals(idClassificacao, that.idClassificacao) &&
               Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClassificacao, idCurso);
    }


    public ClassificacaoCursoIdModel() {
    }

    public ClassificacaoCursoIdModel(Integer idClassificacao, Integer idCurso) {
        setIdClassificacao(idClassificacao);
        setIdCurso(idCurso);
    }

    public Integer getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Integer idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
