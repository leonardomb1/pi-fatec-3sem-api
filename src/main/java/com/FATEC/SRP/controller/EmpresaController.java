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
import com.fatec.srp.models.EmpresaModel;
import com.fatec.srp.service.EmpresaService;

/**
 * Controlador responsável por gerenciar os endpoints relacionados à entidade Empresa.
 * Implementa operações CRUD utilizando o serviço EmpresaService.
 * 
 * Conceitos de OOP:
 * - **Encapsulamento**: As operações de manipulação de dados de Empresa (como leitura, criação e atualização) são encapsuladas dentro do serviço `EmpresaService`, isolando a lógica de negócios e simplificando a interface do controlador.
 * - **Herança**: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * - **Polimorfismo**: O método `getById` e outros utilizam polimorfismo para tratar tipos genéricos de dados. O método retorna um `ResponseEntity` que pode ser adaptado a qualquer tipo de resposta.
 * - **Abstração**: A lógica de como os dados são manipulados é abstraída no serviço `EmpresaService`, permitindo ao controlador realizar operações sem se preocupar com detalhes de implementação.
 */
@RequestMapping("/api/empresa")
@RestController
public class EmpresaController implements IController<EmpresaModel, String> {

    /**
     * Serviço de Empresa injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * - **Injeção de Dependência**: A dependência do `EmpresaService` é injetada pelo Spring Framework, permitindo que o controlador não precise gerenciar a criação e o ciclo de vida do serviço, promovendo um acoplamento fraco entre as classes.
     */
    @Autowired
    private EmpresaService empresaService;

    /**
     * Retorna todos os registros de Empresa disponíveis.
     *
     * @return ResponseEntity contendo uma lista de registros ou status 404 se nenhum registro for encontrado.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de leitura e manipulação dos dados é encapsulada no método `read` do serviço `EmpresaService`. O controlador apenas delega a responsabilidade para o serviço.
     * - **Abstração**: A complexidade da leitura de múltiplos registros é abstraída pelo serviço, simplificando a lógica do controlador.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<EmpresaModel>>> getAll() {
        List<EmpresaModel> lempresa = empresaService.read();

        ResponseBase<List<EmpresaModel>> cBase = ResponseBase.<List<EmpresaModel>>builder()
            .error(false)
            .info("OK")
            .message(lempresa)
            .status(AppConstants.OK)
            .build();

        if (lempresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Retorna um registro específico de Empresa com base no ID fornecido.
     *
     * @param empresaId ID do registro a ser buscado.
     * @return ResponseEntity contendo o registro encontrado ou status 404 se não existir.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O controle da leitura de uma empresa específica é encapsulado no método `read` do serviço. O controlador apenas trata da interação com a camada de serviço.
     * - **Polimorfismo**: O uso do `ResponseEntity` permite a personalização da resposta com base no tipo de dado (`EmpresaModel`), utilizando os conceitos de polimorfismo para adaptar a resposta ao tipo necessário.
     */
    @GetMapping("/{empresaId}")
    public ResponseEntity<ResponseBase<EmpresaModel>> getById(@PathVariable String empresaId) {
        EmpresaModel empresa = new EmpresaModel();
        
        try {
            empresa = empresaService.read(empresaId);
        } catch (Exception ex) {
            ResponseBase<EmpresaModel> noResult = ResponseBase.<EmpresaModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(empresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo registro de Empresa.
     *
     * @param empresa Objeto representando o registro a ser criado.
     * @return ResponseEntity contendo o registro recém-criado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A criação da empresa é encapsulada no método `create` do serviço `EmpresaService`, deixando a lógica de persistência de dados fora do controlador.
     * - **Abstração**: A complexidade da criação do registro é abstraída pela classe de serviço, permitindo que o controlador apenas delegue a operação de criação.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<EmpresaModel>> getBody(@RequestBody EmpresaModel empresa) {
        empresaService.create(empresa);

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(empresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um registro existente de Empresa.
     *
     * @param empresaId ID do registro a ser atualizado.
     * @param empresa Objeto com os dados atualizados.
     * @return ResponseEntity contendo o registro atualizado ou status 404 se o objeto for nulo.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: A lógica de atualização dos dados é encapsulada no serviço `EmpresaService`, mantendo o controlador simples e focado na interação com a camada de serviço.
     * - **Abstração**: A atualização da empresa é tratada pela classe de serviço, abstraindo os detalhes da implementação e permitindo ao controlador apenas chamar o método adequado.
     * - **Polimorfismo**: A resposta de atualização é encapsulada no tipo genérico `ResponseBase`, aproveitando o polimorfismo para se adaptar ao tipo de dados fornecido.
     */
    @PutMapping("/{empresaId}")
    public ResponseEntity<ResponseBase<EmpresaModel>> update(@PathVariable String empresaId, @RequestBody EmpresaModel empresa) {
        EmpresaModel uempresa = empresaService.update(empresaId, empresa);

        ResponseBase<EmpresaModel> cBase = ResponseBase.<EmpresaModel>builder()
            .error(false)
            .info("OK")
            .message(uempresa)
            .status(AppConstants.OK)
            .build();

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }
}
