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
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de FuncionarioTurma (como leitura, criação e atualização) são encapsuladas dentro do serviço `FuncionarioTurmaService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `FuncionarioTurmaService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/funcionarioTurma")
@RestController
public class FuncionarioTurmaController implements IController<FuncionarioTurmaModel, String> {

    /**
     * Serviço de FuncionarioTurma injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `FuncionarioTurmaService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private FuncionarioTurmaService funcionarioTurmaService;

    /**
     * Retorna todos os registros de FuncionarioTurma disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `FuncionarioTurmaService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
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
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de uma empresa específica é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`FuncionarioTurmaModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{funcionarioTurmaId}")
    public ResponseEntity<ResponseBase<FuncionarioTurmaModel>> getById(@PathVariable String funcionarioTurmaId) {
        FuncionarioTurmaModel funcionarioTurma = new FuncionarioTurmaModel();

        try {
            funcionarioTurma = funcionarioTurmaService.read(funcionarioTurmaId);
        } catch (Exception ex) {
            ResponseBase<FuncionarioTurmaModel> noResult = ResponseBase.<FuncionarioTurmaModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

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
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação do funcionário da turma é encapsulada no método `create` do serviço `FuncionarioTurmaService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
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
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `FuncionarioTurmaService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização do registro de funcionário da turma é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
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
