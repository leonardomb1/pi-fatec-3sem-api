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
 * <p>
 * Este controlador implementa a interface IController, demonstrando polimorfismo
 * ao adaptar operações genéricas para o contexto da entidade AlunoModel.
 * </p>
 */
@RequestMapping("/api/aluno")
@RestController
public class AlunoController implements IController<AlunoModel, String> {

    /**
     * Serviço de aluno injetado automaticamente pelo Spring.
     * <p>
     * Utiliza injeção de dependência para promover baixo acoplamento e reutilização do AlunoService.
     * </p>
     */
    @Autowired
    private AlunoService alunoService;

    /**
     * Recupera todos os alunos.
     * <p>
     * Implementa encapsulamento ao retornar os dados em um ResponseBase, estruturando a resposta.
     * </p>
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

        if (lAluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera um aluno específico pelo ID.
     * <p>
     * Demonstra reutilização de código, delegando a lógica de recuperação ao AlunoService.
     * </p>
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

        if (Aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo aluno.
     * <p>
     * Encapsula a lógica de criação e utiliza abstração ao delegar a lógica para o AlunoService.
     * </p> 
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

        if (aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um aluno existente.
     * <p>
     * Demonstra polimorfismo ao implementar a atualização de dados de acordo com o contrato da interface.
     * </p>
     * @param aluno O AlunoModel contendo os novos dados do aluno.
     * @param alunoId O ID do aluno a ser atualizado.
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

        if (aluno == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
