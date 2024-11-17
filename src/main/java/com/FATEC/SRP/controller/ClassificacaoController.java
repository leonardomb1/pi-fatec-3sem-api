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
import com.fatec.srp.models.ClassificacaoModel;
import com.fatec.srp.service.ClassificacaoService;


/**
 * Controlador responsável por gerenciar as operações relacionadas às classificações.
 * Este controlador implementa a interface IController e utiliza o ClassificacaoService para realizar operações CRUD.
 */
@RequestMapping("/api/classificacao")
@RestController
public class ClassificacaoController implements IController<ClassificacaoModel, String> {
    
    /**
     * Serviço de Classificação injetado automaticamente pelo Spring.
     */
    @Autowired
    private ClassificacaoService classificacaoService;
    /**
     * Recupera todas as classificações.
     * @return ResponseEntity contendo uma lista de ClassificacaoModel encapsulada em um ResponseBase.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<ClassificacaoModel>>> getAll() {
        List<ClassificacaoModel> lclassificacao = classificacaoService.read();

        ResponseBase<List<ClassificacaoModel>> cBase = ResponseBase.<List<ClassificacaoModel>>builder()
            .error(false)
            .info("OK")
            .message(lclassificacao)
            .status(AppConstants.OK)
            .build();

        if(lclassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
    /**
     * Recupera uma classificação específica pelo ID.
     * @param classificacaoId O ID da classificação a ser recuperada.
     * @return ResponseEntity contendo um ClassificacaoModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{classificacaoId}")
    public ResponseEntity<ResponseBase<ClassificacaoModel>> getById(@PathVariable String classificacaoId) {
        ClassificacaoModel classificacao = classificacaoService.read(classificacaoId);

        ResponseBase<ClassificacaoModel> cBase = ResponseBase.<ClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(classificacao)
            .status(AppConstants.OK)
            .build();

        if(classificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
    /**
     * Cria uma nova classificação.
     * @param classificacao O ClassificacaoModel contendo os dados da nova classificação.
     * @return ResponseEntity contendo o ClassificacaoModel criado encapsulado em um ResponseBase.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<ClassificacaoModel>> getBody(@RequestBody ClassificacaoModel classificacao) {
        classificacaoService.create(classificacao);

        ResponseBase<ClassificacaoModel> cBase = ResponseBase.<ClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(classificacao)
            .status(AppConstants.OK)
            .build();

        if(classificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza uma classificação existente.
     * @param classificacaoId O ID da classificação a ser atualizada.
     * @param classificacao O ClassificacaoModel contendo os novos dados da classificação.
     * @return ResponseEntity contendo o ClassificacaoModel atualizado encapsulado em um ResponseBase.
     */
    @PutMapping("/{classificacaoId}")
    public ResponseEntity<ResponseBase<ClassificacaoModel>> update(@PathVariable String classificacaoId, @RequestBody ClassificacaoModel classificacao) {
        ClassificacaoModel uclassificacao = classificacaoService.update(classificacaoId, classificacao);

        ResponseBase<ClassificacaoModel> cBase = ResponseBase.<ClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(uclassificacao)
            .status(AppConstants.OK)
            .build();

        if(classificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}