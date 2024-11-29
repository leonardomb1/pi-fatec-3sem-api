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
import com.fatec.srp.models.CursoClassificacaoModel;
import com.fatec.srp.service.CursoClassificacaoService;

/**
 * Controlador responsável por gerenciar as operações relacionadas às classificações de cursos.
 * Este controlador implementa a interface IController e utiliza o CursoClassificacaoService para realizar operações CRUD.
 * 
 * Conceitos de OOP:
 * Encapsulamento: Os métodos da classe controlam as operações sobre os dados (classificação de cursos), permitindo que a lógica de negócio seja isolada do restante da aplicação.
 * Herança: A classe implementa a interface `IController`, o que implica que ela herda o contrato de métodos definidos nessa interface, permitindo que a classe siga uma estrutura comum de controle.
 * Polimorfismo: O método getAll() e outros métodos semelhantes são polimórficos, pois manipulam diferentes tipos de resposta baseados no mesmo tipo de retorno (ResponseEntity).
 */

@RequestMapping("/api/cursoClassificacao")
@RestController
public class CursoClassificacaoController implements IController<CursoClassificacaoModel, String> {
    

    /**
     * Serviço de Classificação de Curso injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * Injeção de Dependência: O Spring framework automaticamente injeta a dependência do serviço `CursoClassificacaoService`, permitindo que o controlador utilize o serviço sem se preocupar com sua criação manual.
     */
    @Autowired
    private CursoClassificacaoService cursoClassificaoService;
    
    /**
     * Recupera todas as classificações de cursos.
     * @return ResponseEntity contendo uma lista de CursoClassificacaoModel encapsulada em um ResponseBase.
     * 
     * Conceito de OOP:
     * Abstração: O método esconde a complexidade de como os dados são recuperados da camada de serviço, retornando apenas um objeto `ResponseEntity` que encapsula a resposta.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoClassificacaoModel>>> getAll() {
        List<CursoClassificacaoModel> lcursoClassificacao = cursoClassificaoService.read();

        ResponseBase<List<CursoClassificacaoModel>> cBase = ResponseBase.<List<CursoClassificacaoModel>>builder()
            .error(false)
            .info("OK")
            .message(lcursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(lcursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera uma classificação de curso específica pelo ID.
     * @param cursoClassificacaoId O ID da classificação de curso a ser recuperada.
     * @return ResponseEntity contendo um CursoClassificacaoModel encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * Encapsulamento: A lógica de busca do curso é encapsulada no método `read()` do serviço, e a resposta é retornada dentro de um objeto `ResponseBase`.
     * Polimorfismo: O método retorna um `ResponseEntity` contendo um tipo de dados genérico, permitindo um comportamento consistente para diferentes tipos de retorno.
     */
    @GetMapping("/{cursoClassificacaoId}")
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> getById(@PathVariable String cursoClassificacaoId) {
        CursoClassificacaoModel cursoClassificacao = new CursoClassificacaoModel();
        
        try {
            cursoClassificacao = cursoClassificaoService.read(cursoClassificacaoId);
        } catch (Exception ex) {
            ResponseBase<CursoClassificacaoModel> noResult = ResponseBase.<CursoClassificacaoModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(cursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria uma nova classificação de curso.
     * @param cursoClassificacao O CursoClassificacaoModel contendo os dados da nova classificação de curso.
     * @return ResponseEntity contendo o CursoClassificacaoModel criado encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * Encapsulamento: O objeto `cursoClassificacao` encapsula os dados da classificação de curso a ser criada, protegendo a estrutura interna de dados do mundo externo.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> getBody(@RequestBody CursoClassificacaoModel cursoClassificacao) {
        cursoClassificaoService.create(cursoClassificacao);

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(cursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza uma classificação de curso existente.
     * @param cursoClassificacaoId O ID da classificação de curso a ser atualizada.
     * @param cursoClassificacao O CursoClassificacaoModel contendo os novos dados da classificação de curso.
     * @return ResponseEntity contendo o CursoClassificacaoModel atualizado encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * Abstração: O método de atualização é uma abstração sobre a lógica real de como os dados são alterados no banco de dados, escondendo a complexidade do código de acesso a dados.
     * Encapsulamento: A atualização dos dados é feita de forma encapsulada dentro do método `update()` no serviço, sem expor a lógica interna diretamente.
     */
    @PutMapping("/{cursoClassificacaoId}")
    public ResponseEntity<ResponseBase<CursoClassificacaoModel>> update(@PathVariable String cursoClassificacaoId, @RequestBody CursoClassificacaoModel cursoClassificacao) {
        CursoClassificacaoModel ucursoClassificacao = cursoClassificaoService.update(cursoClassificacaoId, cursoClassificacao);

        ResponseBase<CursoClassificacaoModel> cBase = ResponseBase.<CursoClassificacaoModel>builder()
            .error(false)
            .info("OK")
            .message(ucursoClassificacao)
            .status(AppConstants.OK)
            .build();

        if(cursoClassificacao == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
