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

/**
 * Controlador responsável por gerenciar as operações relacionadas aos cursos.
 * Este controlador implementa a interface IController e utiliza o CursosService para realizar operações CRUD.
 */
@RequestMapping("/api/curso")
@RestController
public class CursosController implements IController<CursoModel, String> {
    
    /**
     * Serviço de Cursos injetado automaticamente pelo Spring.
     */
    @Autowired
    private CursosService cursosService;
    

    /**
     * Recupera todos os cursos.
     * @return ResponseEntity contendo uma lista de CursoModel encapsulada em um ResponseBase.
     */
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

    /**
     * Recupera um curso específico pelo ID.
     * @param cursoId O ID do curso a ser recuperado.
     * @return ResponseEntity contendo um CursoModel encapsulado em um ResponseBase.
     */
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

    /**
     * Cria um novo curso.
     * @param curso O CursoModel contendo os dados do novo curso.
     * @return ResponseEntity contendo o CursoModel criado encapsulado em um ResponseBase.
     */
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

    /**
     * Atualiza um curso existente.
     * @param cursoId O ID do curso a ser atualizado.
     * @param curso O CursoModel contendo os novos dados do curso.
     * @return ResponseEntity contendo o CursoModel atualizado encapsulado em um ResponseBase.
     */
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