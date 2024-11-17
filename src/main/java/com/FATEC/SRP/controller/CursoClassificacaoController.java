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
import com.fatec.srp.models.CursoClassificacaoModel;
import com.fatec.srp.service.CursoClassificacaoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas às classificações de cursos.
 * Este controlador implementa a interface IController e utiliza o CursoClassificacaoService para realizar operações CRUD.
 */

@RequestMapping("/api/cursoClassificacao")
@RestController
public class CursoClassificacaoController implements IController<CursoClassificacaoModel, String> {
    

    /**
     * Serviço de Classificação de Curso injetado automaticamente pelo Spring.
     */
    @Autowired
    private CursoClassificacaoService cursoClassificaoService;
    
    /**
     * Recupera todas as classificações de cursos.
     * @return ResponseEntity contendo uma lista de CursoClassificacaoModel encapsulada em um ResponseBase.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoClassificacaoModel>>> getAll() {
        List<CursoClassificacaoModel> lcursoClassificacao = cursoClassificaoService.read();

        ResponseBase<List<CursoClassificacaoModel>> cBase = ResponseBase.<List<CursoClassificacaoModel>>builder()
            .error(false)
            .info("OK")
            .message(lcursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(lcursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma classificação de curso específica pelo ID.
     * @param cursoClassificacaoId O ID da classificação de curso a ser recuperada.
     * @return ResponseEntity contendo um CursoClassificacaoModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{cursoClassificacaoId}")
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> getById(@PathVariable String cursoClassificacaoId) {
        CursoClassificacaoModel cursoClassificacao = cursoClassificaoService.read(cursoClassificacaoId);

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(cursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova classificação de curso.
     * @param cursoClassificacao O CursoClassificacaoModel contendo os dados da nova classificação de curso.
     * @return ResponseEntity contendo o CursoClassificacaoModel criado encapsulado em um ResponseBase.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> getBody(@RequestBody CursoClassificacaoModel cursoClassificacao) {
        cursoClassificaoService.create(cursoClassificacao);

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(cursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza uma classificação de curso existente.
     * @param cursoClassificacaoId O ID da classificação de curso a ser atualizada.
     * @param cursoClassificacao O CursoClassificacaoModel contendo os novos dados da classificação de curso.
     * @return ResponseEntity contendo o CursoClassificacaoModel atualizado encapsulado em um ResponseBase.
     */
    @PutMapping("/{cursoClassificacaoId}")
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> update(@PathVariable String cursoClassificacaoId, @RequestBody CursoClassificacaoModel cursoClassificacao) {
        CursoClassificacaoModel ucursoClassificacao = cursoClassificaoService.update(cursoClassificacaoId, cursoClassificacao);

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(ucursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}