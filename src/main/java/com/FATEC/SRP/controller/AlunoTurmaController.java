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
import com.fatec.srp.models.AlunoTurmaModel;
import com.fatec.srp.service.AlunoTurmaService;

/**
 * Controlador responsável por gerenciar as operações relacionadas às associações entre alunos e turmas.
 * <p>
 * Implementa a interface IController para atender aos princípios de polimorfismo e abstração.
 * </p>
 */
@RequestMapping("/api/alunoTurma")
@RestController
public class AlunoTurmaController implements IController<AlunoTurmaModel, String> {

    /**
     * Serviço de AlunoTurma injetado automaticamente pelo Spring.
     * <p>
     * Promove baixo acoplamento ao delegar as operações de negócio para a classe de serviço.
     * </p>
     */
    @Autowired
    private AlunoTurmaService alunoTurmaService;

    /**
     * Recupera todas as associações entre alunos e turmas.
     * <p>
     * Utiliza encapsulamento ao estruturar a resposta em um objeto ResponseBase.
     * </p>
     * @return ResponseEntity contendo uma lista de AlunoTurmaModel encapsulada em um ResponseBase.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<AlunoTurmaModel>>> getAll() {
        List<AlunoTurmaModel> lalunoTurma = alunoTurmaService.read();

        ResponseBase<List<AlunoTurmaModel>> cBase = ResponseBase.<List<AlunoTurmaModel>>builder()
            .error(false)
            .info("OK")
            .message(lalunoTurma)
            .status(AppConstants.OK)
            .build();

        if (lalunoTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma associação específica entre aluno e turma pelo ID.
     * <p>
     * Implementa reutilização de código ao chamar a lógica de leitura definida no serviço.
     * </p>
     * @param alunoTurmaId O ID da associação aluno-turma a ser recuperada.
     * @return ResponseEntity contendo um AlunoTurmaModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{alunoTurmaId}")
    public ResponseEntity<ResponseBase<AlunoTurmaModel>> getById(@PathVariable String alunoTurmaId) {
        AlunoTurmaModel alunoTurma = new AlunoTurmaModel();
             
        try {
            alunoTurma = alunoTurmaService.read(alunoTurmaId);
        } catch (Exception ex) {
            ResponseBase<AlunoTurmaModel> noResult = ResponseBase.<AlunoTurmaModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<AlunoTurmaModel> cBase = ResponseBase.<AlunoTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(alunoTurma)
            .status(AppConstants.OK)
            .build();

        if (alunoTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova associação entre aluno e turma.
     * <p>
     * Demonstra abstração ao delegar a lógica de criação para o serviço de negócio.
     * </p>
     * @param alunoTurma O AlunoTurmaModel contendo os dados da nova associação.
     * @return ResponseEntity contendo o AlunoTurmaModel criado encapsulado em um ResponseBase.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<AlunoTurmaModel>> getBody(@RequestBody AlunoTurmaModel alunoTurma) {
        alunoTurmaService.create(alunoTurma);

        ResponseBase<AlunoTurmaModel> cBase = ResponseBase.<AlunoTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(alunoTurma)
            .status(AppConstants.OK)
            .build();

        if (alunoTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza uma associação existente entre aluno e turma.
     * <p>
     * Aplica polimorfismo ao sobrescrever o contrato da interface para atualizar registros específicos.
     * </p>
     * @param alunoTurmaId O ID da associação aluno-turma a ser atualizada.
     * @param alunoTurma O AlunoTurmaModel contendo os novos dados da associação.
     * @return ResponseEntity contendo o AlunoTurmaModel atualizado encapsulado em um ResponseBase.
     */
    @PutMapping("/{alunoTurmaId}")
    public ResponseEntity<ResponseBase<AlunoTurmaModel>> update(@PathVariable String alunoTurmaId, @RequestBody AlunoTurmaModel alunoTurma) {
        AlunoTurmaModel ualunoTurma = alunoTurmaService.update(alunoTurmaId, alunoTurma);

        ResponseBase<AlunoTurmaModel> cBase = ResponseBase.<AlunoTurmaModel>builder()
            .error(false)
            .info("OK")
            .message(ualunoTurma)
            .status(AppConstants.OK)
            .build();

        if (alunoTurma == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
