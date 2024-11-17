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
import com.fatec.srp.models.CursoTrilhaModel;
import com.fatec.srp.service.CursoTrilhaService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade CursoTrilha.
 * Implementa operações CRUD utilizando o serviço CursoTrilhaService.
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de CursoTrilha (como leitura, criação, e atualização) são encapsuladas dentro do serviço `CursoTrilhaService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar de tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `CursoTrilhaService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/cursoTrilha")
@RestController
public class CursoTrilhaController implements IController<CursoTrilhaModel, String> {

    /**
     * Serviço de CursoTrilha injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `CursoTrilhaService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private CursoTrilhaService cursoTrilhaService;

    /**
     * Retorna todos os registros de CursoTrilha disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `CursoTrilhaService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoTrilhaModel>>> getAll() {
        List<CursoTrilhaModel> lcursoTrilha = cursoTrilhaService.read();

        ResponseBase<List<CursoTrilhaModel>> cBase = ResponseBase.<List<CursoTrilhaModel>>builder()
            .error(false)
            .info("OK")
            .message(lcursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (lcursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de CursoTrilha com base no ID fornecido.
     *
     * @param cursoTrilhaId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de um curso específico é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`CursoTrilhaModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{cursoTrilhaId}")
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> getById(@PathVariable String cursoTrilhaId) {
        CursoTrilhaModel cursoTrilha = cursoTrilhaService.read(cursoTrilhaId);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(cursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de CursoTrilha.
     *
     * @param cursoTrilha Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação do curso é encapsulada no método `create` do serviço `CursoTrilhaService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> getBody(@RequestBody CursoTrilhaModel cursoTrilha) {
        cursoTrilhaService.create(cursoTrilha);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(cursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de CursoTrilha.
     *
     * @param cursoTrilhaId ID do registro a ser atualizado.
     * @param cursoTrilha Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `CursoTrilhaService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização do curso é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
     */
    @PutMapping("/{cursoTrilhaId}")
    public ResponseEntity<ResponseBase<CursoTrilhaModel>> update(@PathVariable String cursoTrilhaId, @RequestBody CursoTrilhaModel cursoTrilha) {
        CursoTrilhaModel ucursoTrilha = cursoTrilhaService.update(cursoTrilhaId, cursoTrilha);

        ResponseBase<CursoTrilhaModel> cBase = ResponseBase.<CursoTrilhaModel>builder()
            .error(false)
            .info("OK")
            .message(ucursoTrilha)
            .status(AppConstants.OK)
            .build();

        if (cursoTrilha == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
