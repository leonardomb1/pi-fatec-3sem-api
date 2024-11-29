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
import com.fatec.srp.models.PreRequisitoCursoModel;
import com.fatec.srp.service.PreRequisitoCursoService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade PreRequisitoCurso.
 * Implementa operações CRUD utilizando o serviço PreRequisitoCursoService.
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de PreRequisitoCurso (como leitura, criação e atualização) são encapsuladas dentro do serviço `PreRequisitoCursoService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `PreRequisitoCursoService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/prerequisitoCurso")
@RestController
public class PreRequisitoCursoController implements IController<PreRequisitoCursoModel, String> {
    
    /**
     * Serviço de PreRequisitoCurso injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `PreRequisitoCursoService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private PreRequisitoCursoService preRequisitoCursoService;

    /**
     * Retorna todos os registros de PreRequisitoCurso disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `PreRequisitoCursoService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<PreRequisitoCursoModel>>> getAll() {
        List<PreRequisitoCursoModel> lprerequisitoCurso = preRequisitoCursoService.read();

        ResponseBase<List<PreRequisitoCursoModel>> cBase = ResponseBase.<List<PreRequisitoCursoModel>>builder()
            .error(false)
            .info("OK")
            .message(lprerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (lprerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de PreRequisitoCurso com base no ID fornecido.
     *
     * @param prerequisitoCursoId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de um pré-requisito de curso específico é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`PreRequisitoCursoModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{prerequisitoCursoId}")
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> getById(@PathVariable String prerequisitoCursoId) {
        PreRequisitoCursoModel prerequisitoCurso = new PreRequisitoCursoModel();
        
        try {
            prerequisitoCurso = preRequisitoCursoService.read(prerequisitoCursoId);
        } catch (Exception ex) {
            ResponseBase<PreRequisitoCursoModel> noResult = ResponseBase.<PreRequisitoCursoModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(prerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (prerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de PreRequisitoCurso.
     *
     * @param prerequisitoCurso Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação do pré-requisito de curso é encapsulada no método `create` do serviço `PreRequisitoCursoService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> getBody(@RequestBody PreRequisitoCursoModel prerequisitoCurso) {
        preRequisitoCursoService.create(prerequisitoCurso);

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(prerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (prerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de PreRequisitoCurso.
     *
     * @param prerequisitoCursoId ID do registro a ser atualizado.
     * @param prerequisitoCurso Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `PreRequisitoCursoService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização do registro de pré-requisito de curso é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
     */
    @PutMapping("/{prerequisitoCursoId}")
    public ResponseEntity<ResponseBase<PreRequisitoCursoModel>> update(@PathVariable String prerequisitoCursoId, @RequestBody PreRequisitoCursoModel prerequisitoCurso) {
        PreRequisitoCursoModel uprerequisitoCurso = preRequisitoCursoService.update(prerequisitoCursoId, prerequisitoCurso);

        ResponseBase<PreRequisitoCursoModel> cBase = ResponseBase.<PreRequisitoCursoModel>builder()
            .error(false)
            .info("OK")
            .message(uprerequisitoCurso)
            .status(AppConstants.OK)
            .build();

        if (uprerequisitoCurso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
