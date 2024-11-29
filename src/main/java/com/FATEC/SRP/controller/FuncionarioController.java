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
import com.fatec.srp.models.FuncionarioModel;
import com.fatec.srp.service.FuncionarioService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade funcionario.
 * Implementa operações CRUD utilizando o serviço FuncionarioService.
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de funcionario (como leitura, criação e atualização) são encapsuladas dentro do serviço `FuncionarioService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `FuncionarioService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/funcionario")
@RestController
public class FuncionarioController implements IController<FuncionarioModel, String> {

    /**
     * Serviço de funcionario injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `FuncionarioService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private FuncionarioService FuncionarioService;

    /**
     * Retorna todos os registros de funcionario disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `FuncionarioService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<FuncionarioModel>>> getAll() {
        List<FuncionarioModel> lfuncionario = FuncionarioService.read();

        ResponseBase<List<FuncionarioModel>> cBase = ResponseBase.<List<FuncionarioModel>>builder()
            .error(false)
            .info("OK")
            .message(lfuncionario)
            .status(AppConstants.OK)
            .build();

        if (lfuncionario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de funcionario com base no ID fornecido.
     *
     * @param funcionarioId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de uma empresa específica é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`FuncionarioModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{funcionarioId}")
    public ResponseEntity<ResponseBase<FuncionarioModel>> getById(@PathVariable String funcionarioId) {
        FuncionarioModel funcionario = new FuncionarioModel();
        
        try {
            funcionario = FuncionarioService.read(funcionarioId);
        } catch (Exception ex) {
            ResponseBase<FuncionarioModel> noResult = ResponseBase.<FuncionarioModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<FuncionarioModel> cBase = ResponseBase.<FuncionarioModel>builder()
            .error(false)
            .info("OK")
            .message(funcionario)
            .status(AppConstants.OK)
            .build();

        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de funcionario.
     *
     * @param funcionario Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação do funcionário da turma é encapsulada no método `create` do serviço `FuncionarioService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<FuncionarioModel>> getBody(@RequestBody FuncionarioModel funcionario) {
        FuncionarioService.create(funcionario);

        ResponseBase<FuncionarioModel> cBase = ResponseBase.<FuncionarioModel>builder()
            .error(false)
            .info("OK")
            .message(funcionario)
            .status(AppConstants.OK)
            .build();

        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de funcionario.
     *
     * @param funcionarioId ID do registro a ser atualizado.
     * @param funcionario Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `FuncionarioService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização do registro de funcionário da turma é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
     */
    @PutMapping("/{funcionarioId}")
    public ResponseEntity<ResponseBase<FuncionarioModel>> update(@PathVariable String funcionarioId, @RequestBody FuncionarioModel funcionario) {
        FuncionarioModel ufuncionario = FuncionarioService.update(funcionarioId, funcionario);

        ResponseBase<FuncionarioModel> cBase = ResponseBase.<FuncionarioModel>builder()
            .error(false)
            .info("OK")
            .message(ufuncionario)
            .status(AppConstants.OK)
            .build();

        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
