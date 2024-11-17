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
import com.fatec.srp.models.TrilhaModel;
import com.fatec.srp.service.TrilhaService;

/**
 * Controlador para gerenciar as trilhas de aprendizado.
 * Esta classe implementa os métodos de CRUD para as trilhas, permitindo operações
 * de criação, leitura e atualização de trilhas através da API.
 */
@RequestMapping("/api/trilha")
@RestController
public class TrilhaController implements IController<TrilhaModel, String> {

    @Autowired
    private TrilhaService trilhaService;

    /**
     * Recupera todas as trilhas cadastradas.
     * 
     * @return ResponseEntity contendo a lista de trilhas ou código de erro 404 se não encontrado.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<TrilhaModel>>> getAll() {
        List<TrilhaModel> ltrilha = trilhaService.read();

        ResponseBase<List<TrilhaModel>> cBase = ResponseBase.<List<TrilhaModel>>builder()
            .error(false)
            .info("OK")
            .message(ltrilha)
            .status(AppConstants.OK)
            .build();

        if(ltrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma trilha pelo seu ID.
     * 
     * @param trilhaId ID da trilha a ser recuperada.
     * @return ResponseEntity contendo a trilha ou código de erro 404 se não encontrado.
     */
    @GetMapping("/{trilhaId}")
    public ResponseEntity<ResponseBase<TrilhaModel>> getById(@PathVariable String trilhaId) {
        TrilhaModel trilha = trilhaService.read(trilhaId);

        ResponseBase<TrilhaModel> cBase = ResponseBase.<TrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(trilha)
            .status(AppConstants.OK)
            .build();

        if(trilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova trilha.
     * 
     * @param trilha Objeto com os dados da trilha a ser criada.
     * @return ResponseEntity contendo a trilha criada ou código de erro 404 se não encontrado.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<TrilhaModel>> getBody(@RequestBody TrilhaModel trilha) {
        trilhaService.create(trilha);

        ResponseBase<TrilhaModel> cBase = ResponseBase.<TrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(trilha)
            .status(AppConstants.OK)
            .build();

        if(trilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza os dados de uma trilha existente.
     * 
     * @param trilhaId ID da trilha a ser atualizada.
     * @param trilha Objeto com os novos dados da trilha.
     * @return ResponseEntity contendo a trilha atualizada ou código de erro 404 se não encontrado.
     */
    @PutMapping("/{trilhaId}")
    public ResponseEntity<ResponseBase<TrilhaModel>> update(@PathVariable String trilhaId, @RequestBody TrilhaModel trilha) {
        TrilhaModel utrilha = trilhaService.update(trilhaId, trilha);

        ResponseBase<TrilhaModel> cBase = ResponseBase.<TrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(utrilha)
            .status(AppConstants.OK)
            .build();

        if(trilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
