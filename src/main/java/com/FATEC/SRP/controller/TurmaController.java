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
import com.fatec.srp.models.TurmaModel;
import com.fatec.srp.service.TurmaService;


/**
 * Controlador para gerenciar as turmas.
 * Esta classe implementa os métodos de CRUD para as turmas, permitindo operações
 * de criação, leitura e atualização de turmas através da API.
 *
 * Conceitos de OOP:
 * - **Encapsulamento**: A classe oculta a complexidade da lógica de negócios relacionada às turmas, delegando a execução das operações para o serviço `TurmaService` e fornecendo uma interface limpa para a interação com a API.
 * - **Injeção de Dependência**: O serviço `TurmaService` é injetado usando `@Autowired`, facilitando a separação de responsabilidades e permitindo que o controlador se concentre apenas no gerenciamento das requisições.
 * - **Padrão de Projeto MVC**: A classe segue o padrão MVC (Model-View-Controller), sendo responsável pela camada de controle da aplicação, manipulando as requisições da API e interagindo com o modelo `TurmaModel`.
 * - **Responsabilidade Única**: Cada método da classe é responsável por uma operação específica: ler, criar ou atualizar turmas, respeitando o princípio de responsabilidade única.
 */
@RequestMapping("/api/turma")
@RestController
public class TurmaController implements IController<TurmaModel, String> {
    
    @Autowired
    private TurmaService turmaService;
    
    /**
     * Recupera todas as turmas cadastradas.
     * 
     * @return ResponseEntity contendo a lista de turmas ou código de erro 404 se não encontrado.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<TurmaModel>>> getAll() {
        List<TurmaModel> lturma = turmaService.read();

        ResponseBase<List<TurmaModel>> cBase = ResponseBase.<List<TurmaModel>>builder()
            .error(false)
            .info("OK")
            .message(lturma)
            .status(AppConstants.OK)
            .build();

        if(lturma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma turma pelo seu ID.
     * 
     * @param turmaId ID da turma a ser recuperada.
     * @return ResponseEntity contendo a turma ou código de erro 404 se não encontrado.
     */
    @GetMapping("/{turmaId}")
    public ResponseEntity<ResponseBase<TurmaModel>> getById(@PathVariable String turmaId) {
        TurmaModel turma = new TurmaModel();
        
        try {
            turma = turmaService.read(turmaId);
        } catch (Exception ex) {
            ResponseBase<TurmaModel> noResult = ResponseBase.<TurmaModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<TurmaModel> cBase = ResponseBase.<TurmaModel>builder()
            .error(false)
            .info("OK")
            .message(turma)
            .status(AppConstants.OK)
            .build();

        if(turma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova turma.
     * 
     * @param turma Objeto com os dados da turma a ser criada.
     * @return ResponseEntity contendo a turma criada ou código de erro 404 se não encontrado.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<TurmaModel>> getBody(@RequestBody TurmaModel turma) {
        turmaService.create(turma);

        ResponseBase<TurmaModel> cBase = ResponseBase.<TurmaModel>builder()
            .error(false)
            .info("OK")
            .message(turma)
            .status(AppConstants.OK)
            .build();

        if(turma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza os dados de uma turma existente.
     * 
     * @param turmaId ID da turma a ser atualizada.
     * @param turma Objeto com os novos dados da turma.
     * @return ResponseEntity contendo a turma atualizada ou código de erro 404 se não encontrado.
     */
    @PutMapping("/{turmaId}")
    public ResponseEntity<ResponseBase<TurmaModel>> update(@PathVariable String turmaId, @RequestBody TurmaModel turma) {
        TurmaModel uturma = turmaService.update(turmaId, turma);

        ResponseBase<TurmaModel> cBase = ResponseBase.<TurmaModel>builder()
            .error(false)
            .info("OK")
            .message(uturma)
            .status(AppConstants.OK)
            .build();

        if(turma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
