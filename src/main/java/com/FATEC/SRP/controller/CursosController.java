package com.fatec.srp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.srp.common.AppConstants;
import com.fatec.srp.models.CursoModel;
import com.fatec.srp.service.CursosService;

@RequestMapping("/api/curso")
@RestController
public class CursosController implements IController<CursoModel, String> {
    
    @Autowired
    private CursosService cursosService;
    
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoModel>>> getAll() {
        List<CursoModel> lCursos = cursosService.read();

        ResponseBase<List<CursoModel>> cBase = ResponseBase.<List<CursoModel>>builder()
            .error(false)
            .info("OK")
            .message(lCursos)
            .status(AppConstants.OK)
            .build();

        if(lCursos == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<ResponseBase<CursoModel>> getById(@PathVariable String cursoId) {
        CursoModel curso = cursosService.read(cursoId);

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(curso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseBase<CursoModel>> getBody(@RequestBody CursoModel curso) {
        cursosService.create(curso);

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(curso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @PutMapping("/{cursoId}")
    public ResponseEntity<ResponseBase<CursoModel>> update(@PathVariable String cursoId, @RequestBody CursoModel curso) {
        CursoModel ucurso = cursosService.update(cursoId, curso);

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(ucurso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}