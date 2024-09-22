package com.FATEC.SRP.model;

import java.io.Serializable;
import java.util.Objects;

public class PreRequisitoIdModel implements Serializable {
    private Integer idCurso;
    private Integer idPreRequisito;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreRequisitoIdModel)) return false;
        PreRequisitoIdModel that = (PreRequisitoIdModel) o;
        return Objects.equals(idCurso, that.idCurso) &&
               Objects.equals(idPreRequisito, that.idPreRequisito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idPreRequisito);
    }

    public PreRequisitoIdModel(Integer idCurso, Integer idPreRequisito) {
        setIdCurso(idCurso);
        setIdPreRequisito(idPreRequisito);
    }

    public PreRequisitoIdModel() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }
}
