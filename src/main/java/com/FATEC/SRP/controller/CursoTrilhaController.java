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
import com.fatec.srp.models.CursoTrilhaModel;
import com.fatec.srp.service.CursoTrilhaService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade CursoTrilha.
 * Implementa operações CRUD utilizando o serviço CursoTrilhaService.
 */
@RequestMapping("/api/cursoTrilha")
@RestController
public class CursoTrilhaController implements IController<CursoTrilhaModel, String> {

    @Autowired
    private CursoTrilhaService cursoTrilhaService;

    /**
     * Retorna todos os registros de CursoTrilha disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoTrilhaModel>>> getAll() {
        List<CursoTrilhaModel> lcursoTrilha = cursoTrilhaService.read();

        ResponseBase<List<CursoTrilhaModel>> cBase = ResponseBase.<List<CursoTrilhaModel>>builder()
            .error(false)
            .info("OK")
            .message(lcursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (lcursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de CursoTrilha com base no ID fornecido.
     *
     * @param cursoTrilhaId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     */
    @GetMapping("/{cursoTrilhaId}")
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> getById(@PathVariable String cursoTrilhaId) {
        CursoTrilhaModel cursoTrilha = cursoTrilhaService.read(cursoTrilhaId);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(cursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de CursoTrilha.
     *
     * @param cursoTrilha Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> getBody(@RequestBody CursoTrilhaModel cursoTrilha) {
        cursoTrilhaService.create(cursoTrilha);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(cursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de CursoTrilha.
     *
     * @param cursoTrilhaId ID do registro a ser atualizado.
     * @param cursoTrilha Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     */
    @PutMapping("/{cursoTrilhaId}")
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> update(@PathVariable String cursoTrilhaId, @RequestBody CursoTrilhaModel cursoTrilha) {
        CursoTrilhaModel ucursoTrilha = cursoTrilhaService.update(cursoTrilhaId, cursoTrilha);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(ucursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
