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
import com.fatec.srp.models.PreRequisitoModel;
import com.fatec.srp.service.PreRequisitoService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade PreRequisito.
 * Implementa operações CRUD utilizando o serviço PreRequisitoService.
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de PreRequisito (como leitura, criação e atualização) são encapsuladas dentro do serviço `PreRequisitoService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `PreRequisitoService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/preRequisito")
@RestController
public class PreRequisitoController implements IController<PreRequisitoModel, String> {

    /**
     * Serviço de PreRequisito injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `PreRequisitoService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private PreRequisitoService preRequisitoService;

    /**
     * Retorna todos os registros de PreRequisito disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `PreRequisitoService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<PreRequisitoModel>>> getAll() {
        List<PreRequisitoModel> lPreRequisito = preRequisitoService.read();

        ResponseBase<List<PreRequisitoModel>> cBase = ResponseBase.<List<PreRequisitoModel>>builder()
            .error(false)
            .info("OK")
            .message(lPreRequisito)
            .status(AppConstants.OK)
            .build();

        if (lPreRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de PreRequisito com base no ID fornecido.
     *
     * @param preRequisitoId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de um pré-requisito específico é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`PreRequisitoModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{preRequisitoId}")
    public ResponseEntity<ResponseBase<PreRequisitoModel>> getById(@PathVariable String preRequisitoId) {
        PreRequisitoModel preRequisito = preRequisitoService.read(preRequisitoId);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(preRequisito)
            .status(AppConstants.OK)
            .build();

        if (preRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de PreRequisito.
     *
     * @param preRequisito Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação do pré-requisito é encapsulada no método `create` do serviço `PreRequisitoService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<PreRequisitoModel>> getBody(@RequestBody PreRequisitoModel preRequisito) {
        preRequisitoService.create(preRequisito);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(preRequisito)
            .status(AppConstants.OK)
            .build();

        if (preRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de PreRequisito.
     *
     * @param preRequisitoId ID do registro a ser atualizado.
     * @param preRequisito Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `PreRequisitoService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização do registro de pré-requisito é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
     */
    @PutMapping("/{preRequisitoId}")
    public ResponseEntity<ResponseBase<PreRequisitoModel>> update(@PathVariable String preRequisitoId, @RequestBody PreRequisitoModel preRequisito) {
        PreRequisitoModel uPreRequisito = preRequisitoService.update(preRequisitoId, preRequisito);

        ResponseBase<PreRequisitoModel> cBase = ResponseBase.<PreRequisitoModel>builder()
            .error(false)
            .info("OK")
            .message(uPreRequisito)
            .status(AppConstants.OK)
            .build();

        if (uPreRequisito == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
