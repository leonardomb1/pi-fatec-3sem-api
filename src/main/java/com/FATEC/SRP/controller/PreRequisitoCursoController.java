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
import com.fatec.srp.models.PreRequisitoCursoModel;
import com.fatec.srp.service.PreRequisitoCursoService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade PreRequisitoCurso.
 * Implementa operações CRUD utilizando o serviço PreRequisitoCursoService.
 */
@RequestMapping("/api/prerequisitoCurso")
@RestController
public class PreRequisitoCursoController implements IController<PreRequisitoCursoModel, String> {
    
    @Autowired
    private PreRequisitoCursoService preRequisitoCursoService;

    /**
     * Retorna todos os registros de PreRequisitoCurso disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<PreRequisitoCursoModel>>> getAll() {
        List<PreRequisitoCursoModel> lprerequisitoCurso = preRequisitoCursoService.read();

        ResponseBase<List<PreRequisitoCursoModel>> cBase = ResponseBase.<List<PreRequisitoCursoModel>>builder()
            .error(false)
            .info("OK")
            .message(lprerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (lprerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de PreRequisitoCurso com base no ID fornecido.
     *
     * @param prerequisitoCursoId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     */
    @GetMapping("/{prerequisitoCursoId}")
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> getById(@PathVariable String prerequisitoCursoId) {
        PreRequisitoCursoModel prerequisitoCurso = preRequisitoCursoService.read(prerequisitoCursoId);

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(prerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (prerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de PreRequisitoCurso.
     *
     * @param prerequisitoCurso Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> getBody(@RequestBody PreRequisitoCursoModel prerequisitoCurso) {
        preRequisitoCursoService.create(prerequisitoCurso);

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(prerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (prerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de PreRequisitoCurso.
     *
     * @param prerequisitoCursoId ID do registro a ser atualizado.
     * @param prerequisitoCurso Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     */
    @PutMapping("/{prerequisitoCursoId}")
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> update(@PathVariable String prerequisitoCursoId, @RequestBody PreRequisitoCursoModel prerequisitoCurso) {
        PreRequisitoCursoModel uprerequisitoCurso = preRequisitoCursoService.update(prerequisitoCursoId, prerequisitoCurso);

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(uprerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (uprerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
