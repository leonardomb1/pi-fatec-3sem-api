package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.ClassificacaoModel;
import com.fatec.srp.models.CursoClassificacaoModel;
import com.fatec.srp.models.CursoModel;
import com.fatec.srp.repositories.ClassificacaoRepository;
import com.fatec.srp.repositories.CursoClassificacaoRepository;
import com.fatec.srp.repositories.CursosRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link CursoClassificacaoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link CursoClassificacaoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link CursoClassificacaoRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `CursoClassificacaoService` encapsula as operações relacionadas aos registros de cursos e classificações, garantindo que as interações com o banco de dados sejam feitas de maneira controlada.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única, oferecendo uma única camada para a lógica de negócios relacionada ao CRUD dos registros de cursos e classificações.
 * - **Injeção de Dependência**: O repositório `CursoClassificacaoRepository` é injetado automaticamente pelo Spring, permitindo que a classe `CursoClassificacaoService` se concentre na lógica de negócio, enquanto o repositório lida com a persistência de dados.
 * - **Transações**: A anotação `@Transactional` garante que as operações de criação, atualização e exclusão de dados sejam realizadas dentro de uma transação, o que assegura a consistência e a integridade dos dados.
 */
@Service
public class CursoClassificacaoService implements IService<CursoClassificacaoModel, String> {

    @Autowired
    private CursoClassificacaoRepository CursoClassificacaoRepository;

    @Autowired
    private CursosRepository CursosRepository;

    @Autowired
    private ClassificacaoRepository ClassificacaoRepository;

    /**
     * Recupera todos os registros de curso e classificação.
     * 
     * @return Lista de objetos {@link CursoClassificacaoModel}.
     */
    public List<CursoClassificacaoModel> read() {
        List<CursoClassificacaoModel> cList = CursoClassificacaoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de curso e classificação pelo seu ID.
     * 
     * @param cursoClassificacaoId ID do curso e classificação.
     * @return Objeto {@link CursoClassificacaoModel} correspondente ao ID fornecido.
     */
    public CursoClassificacaoModel read(String cursoClassificacaoId) {
        int parsedId = Integer.parseInt(cursoClassificacaoId);
        CursoClassificacaoModel cursoClassificacao = CursoClassificacaoRepository.findById(parsedId).get();
        return cursoClassificacao;
    }
    
    /**
     * Cria um novo registro de curso e classificação no banco de dados.
     * 
     * @param model Objeto {@link CursoClassificacaoModel} contendo os dados do novo curso e classificação.
     * @return O objeto {@link CursoClassificacaoModel} persistido.
     */
    @Transactional
    public CursoClassificacaoModel create(CursoClassificacaoModel model) {

        Optional<CursoModel> cursoOptional = CursosRepository.findById(model.getCurso().getId());
        model.setCurso(cursoOptional.get());

        Optional<ClassificacaoModel> classificacaoOptional = ClassificacaoRepository.findById(model.getClassificacao().getId());
        model.setClassificacao(classificacaoOptional.get());

        CursoClassificacaoModel cursoClassificacao = CursoClassificacaoRepository.save(model);
        return cursoClassificacao;
    }
    
    /**
     * Atualiza os dados de um curso e classificação existente no banco de dados.
     * 
     * @param cursoClassificacaoId ID do curso e classificação a ser atualizado.
     * @param uModel Objeto {@link CursoClassificacaoModel} com os novos dados de curso e classificação.
     * @return O objeto {@link CursoClassificacaoModel} atualizado.
     */
    @Transactional
    public CursoClassificacaoModel update(String cursoClassificacaoId, CursoClassificacaoModel uModel) {
        CursoClassificacaoModel cursoClassificacao = read(cursoClassificacaoId);

        Optional<CursoModel> cursoOptional = CursosRepository.findById(uModel.getCurso().getId());
        uModel.setCurso(cursoOptional.get());

        Optional<ClassificacaoModel> classificacaoOptional = ClassificacaoRepository.findById(uModel.getClassificacao().getId());
        uModel.setClassificacao(classificacaoOptional.get());

        CursoClassificacaoRepository.save(cursoClassificacao);
        return cursoClassificacao;
    }
    
    /**
     * Exclui um curso e classificação pelo ID.
     * 
     * @param cursoClassificacaoId ID do curso e classificação a ser excluído.
     * @return O objeto {@link CursoClassificacaoModel} que foi excluído.
     */
    @Transactional
    public CursoClassificacaoModel delete(String cursoClassificacaoId) {
        int parsedId = Integer.parseInt(cursoClassificacaoId);
        CursoClassificacaoModel cursoClassificacaoToDelete = read(cursoClassificacaoId);
        CursoClassificacaoRepository.deleteById(parsedId);
        return cursoClassificacaoToDelete;
    }
}
