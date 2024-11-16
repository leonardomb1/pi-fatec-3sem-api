package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CursoModel;
import com.fatec.srp.repositories.CursosRepository;

import java.util.List;

@Service
public class CursosService implements IService<CursoModel, String> {

    @Autowired
    private CursosRepository cursosRepository;

    public List<CursoModel> read() {
        List<CursoModel> cList = cursosRepository.findAll();
        return cList;
    }

    public CursoModel read(String cursoId) {
        int parsedId = Integer.parseInt(cursoId);
        CursoModel curso = cursosRepository.findById(parsedId).get();
        return curso;
    }
    
    @Transactional
    public CursoModel create(CursoModel model) {
        CursoModel curso = cursosRepository.save(model);
        return curso;
    }
    
    @Transactional
    public CursoModel update(String cursoId, CursoModel uModel) {
        CursoModel curso = read(cursoId);

        curso.setDescCurso(uModel.getDescCurso());
        curso.setNomeCurso(uModel.getNomeCurso());
        curso.setProgramacao(uModel.getProgramacao());

        cursosRepository.save(curso);
        return curso;
    }
    
    @Transactional
    public CursoModel delete(String cursoId) {
        int parsedId = Integer.parseInt(cursoId);
        CursoModel cursoToDelete = read(cursoId);
        cursosRepository.deleteById(parsedId);
        return cursoToDelete;
    }
}
