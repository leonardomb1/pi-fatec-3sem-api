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
import com.fatec.srp.models.AlunoModel;
import com.fatec.srp.service.AlunoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos alunos.
 * Este controlador implementa a interface IController e utiliza o AlunoService para realizar operações CRUD.
 */
@RequestMapping("/api/aluno")
@RestController
public class AlunoController implements IController<AlunoModel, String> {
    
    /**
     * Serviço de aluno injetado automaticamente pelo Spring.
     */
    @Autowired
    private AlunoService alunoService;
    
    /**
     * Recupera todos os alunos.
     * @return ResponseEntity contendo uma lista de AlunoModel encapsulada em um ResponseBase.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<AlunoModel>>> getAll() {
        List<AlunoModel> lAluno = alunoService.read();

        ResponseBase<List<AlunoModel>> cBase = ResponseBase.<List<AlunoModel>>builder()
            .error(false)
            .info("OK")
            .message(lAluno)
            .status(AppConstants.OK)
            .build();

        if(lAluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera um aluno específico pelo ID.
     * @param alunoId O ID do aluno a ser recuperado.
     * @return ResponseEntity contendo um AlunoModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{alunoId}")
    public ResponseEntity<ResponseBase<AlunoModel>> getById(@PathVariable String alunoId) {
        AlunoModel Aluno = alunoService.read(alunoId);

        ResponseBase<AlunoModel> cBase = ResponseBase.<AlunoModel>builder()
            .error(false)
            .info("OK")
            .message(Aluno)
            .status(AppConstants.OK)
            .build();

        if(Aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo aluno.
     * @param aluno O AlunoModel contendo os dados do novo aluno.
     * @return ResponseEntity contendo o AlunoModel criado encapsulado em um ResponseBase.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<AlunoModel>> getBody(@RequestBody AlunoModel aluno) {
        alunoService.create(aluno);

        ResponseBase<AlunoModel> cBase = ResponseBase.<AlunoModel>builder()
            .error(false)
            .info("OK")
            .message(aluno)
            .status(AppConstants.OK)
            .build();

        if(aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um aluno existente.
     * @param alunoId O ID do aluno a ser atualizado.
     * @param aluno O AlunoModel contendo os novos dados do aluno.
     * @return ResponseEntity contendo o AlunoModel atualizado encapsulado em um ResponseBase.
     */
    @PutMapping("/{alunoId}")
    public ResponseEntity<ResponseBase<AlunoModel>> update(@PathVariable String alunoId, @RequestBody AlunoModel aluno) {
        AlunoModel uAluno = alunoService.update(alunoId, aluno);

        ResponseBase<AlunoModel> cBase = ResponseBase.<AlunoModel>builder()
            .error(false)
            .info("OK")
            .message(uAluno)
            .status(AppConstants.OK)
            .build();

        if(aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}