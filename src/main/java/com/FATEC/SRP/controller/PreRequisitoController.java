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
import com.fatec.srp.models.PreRequisitoModel;
import com.fatec.srp.service.PreRequisitoService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade PreRequisito.
 * Implementa operações CRUD utilizando o serviço PreRequisitoService.
 */
@RequestMapping("/api/preRequisito")
@RestController
public class PreRequisitoController implements IController<PreRequisitoModel, String> {

    @Autowired
    private PreRequisitoService preRequisitoService;

    /**
     * Retorna todos os registros de PreRequisito disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<PreRequisitoModel>>> getAll() {
        List<PreRequisitoModel> lPreRequisito = preRequisitoService.read();

        ResponseBase<List<PreRequisitoModel>> cBase = ResponseBase.<List<PreRequisitoModel>>builder()
            .error(false)
            .info("OK")
            .message(lPreRequisito)
            .status(AppConstants.OK)
            .build();

        if (lPreRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de PreRequisito com base no ID fornecido.
     *
     * @param preRequisitoId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     */
    @GetMapping("/{preRequisitoId}")
    public ResponseEntity<ResponseBase<PreRequisitoModel>> getById(@PathVariable String preRequisitoId) {
        PreRequisitoModel PreRequisito = preRequisitoService.read(preRequisitoId);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(PreRequisito)
            .status(AppConstants.OK)
            .build();

        if (PreRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de PreRequisito.
     *
     * @param preRequisito Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<PreRequisitoModel>> getBody(@RequestBody PreRequisitoModel preRequisito) {
        preRequisitoService.create(preRequisito);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(preRequisito)
            .status(AppConstants.OK)
            .build();

        if (preRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de PreRequisito.
     *
     * @param preRequisitoId ID do registro a ser atualizado.
     * @param preRequisito Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     */
    @PutMapping("/{preRequisitoId}")
    public ResponseEntity<ResponseBase<PreRequisitoModel>> update(@PathVariable String preRequisitoId, @RequestBody PreRequisitoModel preRequisito) {
        PreRequisitoModel uPreRequisito = preRequisitoService.update(preRequisitoId, preRequisito);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(uPreRequisito)
            .status(AppConstants.OK)
            .build();

        if (uPreRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
