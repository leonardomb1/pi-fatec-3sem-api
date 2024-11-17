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
import com.fatec.srp.models.EmpresaModel;
import com.fatec.srp.service.EmpresaService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade Empresa.
 * Implementa operações CRUD utilizando o serviço EmpresaService.
 */
@RequestMapping("/api/empresa")
@RestController
public class EmpresaController implements IController<EmpresaModel, String> {

    @Autowired
    private EmpresaService empresaService;

    /**
     * Retorna todos os registros de Empresa disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<EmpresaModel>>> getAll() {
        List<EmpresaModel> lempresa = empresaService.read();

        ResponseBase<List<EmpresaModel>> cBase = ResponseBase.<List<EmpresaModel>>builder()
            .error(false)
            .info("OK")
            .message(lempresa)
            .status(AppConstants.OK)
            .build();

        if (lempresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de Empresa com base no ID fornecido.
     *
     * @param empresaId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     */
    @GetMapping("/{empresaId}")
    public ResponseEntity<ResponseBase<EmpresaModel>> getById(@PathVariable String empresaId) {
        EmpresaModel empresa = empresaService.read(empresaId);

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(empresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de Empresa.
     *
     * @param empresa Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<EmpresaModel>> getBody(@RequestBody EmpresaModel empresa) {
        empresaService.create(empresa);

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(empresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de Empresa.
     *
     * @param empresaId ID do registro a ser atualizado.
     * @param empresa Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     */
    @PutMapping("/{empresaId}")
    public ResponseEntity<ResponseBase<EmpresaModel>> update(@PathVariable String empresaId, @RequestBody EmpresaModel empresa) {
        EmpresaModel uempresa = empresaService.update(empresaId, empresa);

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(uempresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
