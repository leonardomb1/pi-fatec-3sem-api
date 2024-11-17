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
import com.fatec.srp.models.FuncionarioTurmaModel;
import com.fatec.srp.service.FuncionarioTurmaService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade FuncionarioTurma.
 * Implementa operações CRUD utilizando o serviço FuncionarioTurmaService.
 */
@RequestMapping("/api/funcionarioTurma")
@RestController
public class FuncionarioTurmaController implements IController<FuncionarioTurmaModel, String> {

    @Autowired
    private FuncionarioTurmaService funcionarioTurmaService;

    /**
     * Retorna todos os registros de FuncionarioTurma disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<FuncionarioTurmaModel>>> getAll() {
        List<FuncionarioTurmaModel> lfuncionarioTurma = funcionarioTurmaService.read();

        ResponseBase<List<FuncionarioTurmaModel>> cBase = ResponseBase.<List<FuncionarioTurmaModel>>builder()
            .error(false)
            .info("OK")
            .message(lfuncionarioTurma)
            .status(AppConstants.OK)
            .build();

        if (lfuncionarioTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de FuncionarioTurma com base no ID fornecido.
     *
     * @param funcionarioTurmaId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     */
    @GetMapping("/{funcionarioTurmaId}")
    public ResponseEntity<ResponseBase<FuncionarioTurmaModel>> getById(@PathVariable String funcionarioTurmaId) {
        FuncionarioTurmaModel funcionarioTurma = funcionarioTurmaService.read(funcionarioTurmaId);

        ResponseBase<FuncionarioTurmaModel> cBase = ResponseBase.<FuncionarioTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(funcionarioTurma)
            .status(AppConstants.OK)
            .build();

        if (funcionarioTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de FuncionarioTurma.
     *
     * @param funcionarioTurma Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<FuncionarioTurmaModel>> getBody(@RequestBody FuncionarioTurmaModel funcionarioTurma) {
        funcionarioTurmaService.create(funcionarioTurma);

        ResponseBase<FuncionarioTurmaModel> cBase = ResponseBase.<FuncionarioTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(funcionarioTurma)
            .status(AppConstants.OK)
            .build();

        if (funcionarioTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de FuncionarioTurma.
     *
     * @param funcionarioTurmaId ID do registro a ser atualizado.
     * @param funcionarioTurma Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     */
    @PutMapping("/{funcionarioTurmaId}")
    public ResponseEntity<ResponseBase<FuncionarioTurmaModel>> update(@PathVariable String funcionarioTurmaId, @RequestBody FuncionarioTurmaModel funcionarioTurma) {
        FuncionarioTurmaModel ufuncionarioTurma = funcionarioTurmaService.update(funcionarioTurmaId, funcionarioTurma);

        ResponseBase<FuncionarioTurmaModel> cBase = ResponseBase.<FuncionarioTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(ufuncionarioTurma)
            .status(AppConstants.OK)
            .build();

        if (funcionarioTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
