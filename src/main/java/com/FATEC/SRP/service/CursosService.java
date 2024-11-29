package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CursoModel;
import com.fatec.srp.repositories.CursosRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link CursoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link CursoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link CursosRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `CursosService` encapsula a lógica de manipulação de cursos, fornecendo métodos claros e controlados para as operações de CRUD, o que garante que a lógica de negócios seja separada da camada de persistência.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única, sendo responsável exclusivamente pela lógica de negócios relacionada aos cursos. Isso facilita a manutenção e o teste da aplicação.
 * - **Injeção de Dependência**: O repositório `CursosRepository` é injetado automaticamente pelo Spring, o que permite que a classe `CursosService` se concentre na lógica de negócios, sem se preocupar diretamente com a implementação da persistência de dados.
 * - **Transações**: A anotação `@Transactional` garante que as operações de criação, atualização e exclusão de registros de cursos sejam realizadas dentro de uma transação, assegurando que as mudanças no banco de dados sejam atômicas e consistentes.
 */
@Service
public class CursosService implements IService<CursoModel, String> {

    @Autowired
    private CursosRepository cursosRepository;

    /**
     * Recupera todos os cursos registrados.
     * 
     * @return Lista de objetos {@link CursoModel}.
     */
    public List<CursoModel> read() {
        List<CursoModel> cList = cursosRepository.findAll();
        return cList;
    }

    /**
     * Recupera um curso específico pelo seu ID.
     * 
     * @param cursoId ID do curso.
     * @return Objeto {@link CursoModel} correspondente ao ID fornecido.
     */
    public CursoModel read(String cursoId) {
        int parsedId = Integer.parseInt(cursoId);
        CursoModel curso = cursosRepository.findById(parsedId).get();
        return curso;
    }
    
    /**
     * Cria um novo curso no banco de dados.
     * 
     * @param model Objeto {@link CursoModel} contendo os dados do novo curso.
     * @return O objeto {@link CursoModel} persistido.
     */
    @Transactional
    public CursoModel create(CursoModel model) {
        CursoModel curso = cursosRepository.save(model);
        return curso;
    }
    
    /**
     * Atualiza os dados de um curso existente no banco de dados.
     * 
     * @param cursoId ID do curso a ser atualizado.
     * @param uModel Objeto {@link CursoModel} com os novos dados do curso.
     * @return O objeto {@link CursoModel} atualizado.
     */
    @Transactional
    public CursoModel update(String cursoId, CursoModel uModel) {
        CursoModel curso = read(cursoId);

        curso.setDescCurso(uModel.getDescCurso());
        curso.setNomeCurso(uModel.getNomeCurso());
        curso.setProgramacao(uModel.getProgramacao());
        curso.setCargaHoraria(uModel.getCargaHoraria());
        curso.setRequisitos(uModel.getRequisitos());
        curso.setValorCurso(uModel.getValorCurso());

        cursosRepository.save(curso);
        return curso;
    }
    
    /**
     * Exclui um curso pelo ID.
     * 
     * @param cursoId ID do curso a ser excluído.
     * @return O objeto {@link CursoModel} que foi excluído.
     */
    @Transactional
    public CursoModel delete(String cursoId) {
        int parsedId = Integer.parseInt(cursoId);
        CursoModel cursoToDelete = read(cursoId);
        cursosRepository.deleteById(parsedId);
        return cursoToDelete;
    }
}
