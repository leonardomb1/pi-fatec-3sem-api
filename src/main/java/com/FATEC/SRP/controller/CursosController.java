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
import com.fatec.srp.models.CursoModel;
import com.fatec.srp.service.CursosService;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos cursos.
 * Este controlador implementa a interface IController e utiliza o CursosService para realizar operações CRUD.  
 * 
 * Conceitos de OOP:
 * Encapsulamento: Os métodos da classe controlam o acesso aos dados dos cursos, escondendo a complexidade do processo de manipulação e proporcionando uma interface simples de interação.
 * Herança: A classe implementa a interface `IController`, que define um contrato de operações CRUD. Isso permite que diferentes controladores implementem operações comuns de forma padronizada.
 * Polimorfismo: Os métodos de resposta, como `getAll()` e outros, utilizam polimorfismo, pois retornam tipos genéricos encapsulados, adaptando o comportamento de acordo com o tipo específico de dados.
 * Abstração: A abstração é usada para esconder os detalhes da implementação dos serviços de cursos, como a lógica interna de criação, leitura e atualização dos cursos, permitindo que o controlador interaja de forma simples e intuitiva.
 */
@RequestMapping("/api/curso")
@RestController
public class CursosController implements IController<CursoModel, String> {
    
    /**
     * Serviço de Cursos injetado automaticamente pelo Spring.
     * 
     * Conceito de OOP:
     * Injeção de Dependência: O Spring Framework injeta a dependência de `CursosService`, facilitando a gestão da criação e controle de instâncias e evitando acoplamento direto entre o controlador e a lógica de negócios.
     */
    @Autowired
    private CursosService cursosService;
    

    /**
     * Recupera todos os cursos.
     * @return ResponseEntity contendo uma lista de CursoModel encapsulada em um ResponseBase.
     * 
     * Conceito de OOP:
     * - **Abstração**: A complexidade do processo de obtenção dos cursos é abstraída para a classe de serviço `CursosService`, que é responsável por interagir com o banco de dados e retornar os dados em um formato simplificado.
     * - **Encapsulamento**: A lógica de negócios está encapsulada no serviço, e o controlador apenas delega as operações sem expor detalhes internos.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CursoModel>>> getAll() {
        List<CursoModel> lCursos = cursosService.read();

        ResponseBase<List<CursoModel>> cBase = ResponseBase.<List<CursoModel>>builder()
            .error(false)
            .info("OK")
            .message(lCursos)
            .status(AppConstants.OK)
            .build();

        if(lCursos == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera um curso específico pelo ID.
     * @param cursoId O ID do curso a ser recuperado.
     * @return ResponseEntity contendo um CursoModel encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: Os dados do curso específico são encapsulados dentro do modelo `CursoModel`, e o método de leitura abstrai o processo de recuperação do banco de dados.
     * - **Polimorfismo**: O método `getById` é genérico e permite o uso de diferentes tipos de modelos (nesse caso, `CursoModel`), adaptando-se ao tipo de dado passado.
     */
    @GetMapping("/{cursoId}")
    public ResponseEntity<ResponseBase<CursoModel>> getById(@PathVariable String cursoId) {
        CursoModel curso = new CursoModel();
        
        try {
            curso = cursosService.read(cursoId);
        } catch (Exception ex) {
            ResponseBase<CursoModel> noResult = ResponseBase.<CursoModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(curso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo curso.
     * @param curso O CursoModel contendo os dados do novo curso.
     * @return ResponseEntity contendo o CursoModel criado encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: Os dados do novo curso são encapsulados no objeto `curso` passado no corpo da requisição, evitando que o controlador manipule diretamente os dados.
     * - **Abstração**: O processo de criação do curso é abstraído no método `create` do serviço `CursosService`, simplificando a lógica do controlador.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CursoModel>> getBody(@RequestBody CursoModel curso) {
        cursosService.create(curso);

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(curso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um curso existente.
     * @param cursoId O ID do curso a ser atualizado.
     * @param curso O CursoModel contendo os novos dados do curso.
     * @return ResponseEntity contendo o CursoModel atualizado encapsulado em um ResponseBase.
     * 
     * Conceito de OOP:
     * - **Encapsulamento**: O modelo `CursoModel` encapsula os dados do curso, protegendo a integridade das informações e permitindo uma fácil modificação por meio de métodos específicos.
     * - **Abstração**: A lógica de atualização do curso é abstraída no serviço `CursosService`, e o controlador simplesmente delega a responsabilidade de modificar o curso.
     * - **Polimorfismo**: O método `update` lida com tipos genéricos e pode ser reutilizado em outras partes da aplicação, mantendo a flexibilidade no uso de modelos diferentes.
     */
    @PutMapping("/{cursoId}")
    public ResponseEntity<ResponseBase<CursoModel>> update(@PathVariable String cursoId, @RequestBody CursoModel curso) {
        CursoModel ucurso = cursosService.update(cursoId, curso);

        ResponseBase<CursoModel> cBase = ResponseBase.<CursoModel>builder()
            .error(false)
            .info("OK")
            .message(ucurso)
            .status(AppConstants.OK)
            .build();

        if(curso == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
