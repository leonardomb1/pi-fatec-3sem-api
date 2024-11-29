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
 * <p>
 * Implementa a interface IController para promover abstração e reutilização de código. 
 * Encapsula as regras de negócio no serviço ClassificacaoService, promovendo baixo acoplamento e separação de responsabilidades.
 * </p>
 */
@RequestMapping("/api/classificacao")
@RestController
public class ClassificacaoController implements IController<ClassificacaoModel, String> {

    /**
     * Serviço de Classificação injetado automaticamente pelo Spring.
     * <p>
     * O uso de injeção de dependência (Dependency Injection) favorece a inversão de controle e facilita a testabilidade.
     * </p>
     */
    @Autowired
    private ClassificacaoService classificacaoService;

    /**
     * Recupera todas as classificações.
     * <p>
     * Aplica abstração ao encapsular a lógica de negócio no serviço e utiliza encapsulamento para organizar a resposta no objeto ResponseBase.
     * </p>
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

        if (lclassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma classificação específica pelo ID.
     * <p>
     * Implementa polimorfismo ao sobrescrever o método definido na interface IController.
     * </p>
     * @param classificacaoId O ID da classificação a ser recuperada.
     * @return ResponseEntity contendo um ClassificacaoModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{classificacaoId}")
    public ResponseEntity<ResponseBase<ClassificacaoModel>> getById(@PathVariable String classificacaoId) {
        ClassificacaoModel classificacao = new ClassificacaoModel();
        
        try {
            classificacao = classificacaoService.read(classificacaoId);
        } catch (Exception ex) {
            ResponseBase<ClassificacaoModel> noResult = ResponseBase.<ClassificacaoModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<ClassificacaoModel> cBase = ResponseBase.<ClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(classificacao)
            .status(AppConstants.OK)
            .build();

        if (classificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova classificação.
     * <p>
     * Aplica o princípio de encapsulamento ao organizar os dados no modelo ClassificacaoModel e delega a lógica de persistência ao serviço.
     * </p>
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

        if (classificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza uma classificação existente.
     * <p>
     * Aplica o princípio de abstração e reutilização ao delegar a lógica de atualização para o serviço ClassificacaoService.
     * </p>
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

        if (uclassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
