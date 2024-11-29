package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.AlunoTurmaModel;
import com.fatec.srp.models.TurmaModel;
import com.fatec.srp.models.AlunoModel;
import com.fatec.srp.repositories.AlunoRepository;
import com.fatec.srp.repositories.TurmaRepository;
import com.fatec.srp.repositories.AlunoTurmaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link AlunoTurmaModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link AlunoTurmaModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link AlunoTurmaRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `AlunoTurmaService` encapsula as operações relacionadas à matrícula de alunos em turmas, tornando essas operações simples de usar e integrando a lógica de negócio.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única, sendo responsável exclusivamente pelas operações de matrícula de alunos em turmas.
 * - **Injeção de Dependência**: O repositório `AlunoTurmaRepository` é injetado automaticamente, promovendo a separação de responsabilidades e facilitando a manutenção do código.
 * - **Transações**: A anotação `@Transactional` garante que as operações de criação, atualização e exclusão sejam atômicas, garantindo que as transações sejam consistentes.
 */
@Service
public class AlunoTurmaService implements IService<AlunoTurmaModel, String> {

    @Autowired
    private AlunoTurmaRepository AlunoTurmaRepository;

    @Autowired
    private TurmaRepository TurmaRepository;

    @Autowired
    private AlunoRepository AlunoRepository;

    /**
     * Recupera todos os registros de alunos matriculados em turmas.
     * 
     * @return Lista de objetos {@link AlunoTurmaModel}.
     */
    public List<AlunoTurmaModel> read() {
        List<AlunoTurmaModel> cList = AlunoTurmaRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de aluno matriculado em uma turma pelo seu ID.
     * 
     * @param AlunoTurmaId ID do aluno na turma.
     * @return Objeto {@link AlunoTurmaModel} correspondente ao ID fornecido.
     */
    public AlunoTurmaModel read(String AlunoTurmaId) {
        int parsedId = Integer.parseInt(AlunoTurmaId);
        AlunoTurmaModel AlunoTurma = AlunoTurmaRepository.findById(parsedId).get();
        return AlunoTurma;
    }
    
    /**
     * Cria um novo registro de aluno matriculado em uma turma no banco de dados.
     * 
     * @param model Objeto {@link AlunoTurmaModel} contendo os dados da matrícula do aluno.
     * @return O objeto {@link AlunoTurmaModel} persistido.
     */
    @Transactional
    public AlunoTurmaModel create(AlunoTurmaModel model) {

        Optional<AlunoModel> alunoOptional = AlunoRepository.findById(model.getAluno().getId());
        model.setAluno(alunoOptional.get());

        Optional<TurmaModel> turmaOptional = TurmaRepository.findById(model.getTurma().getId());
        model.setTurma(turmaOptional.get());

        AlunoTurmaModel AlunoTurma = AlunoTurmaRepository.save(model);
        return AlunoTurma;
    }
    
    /**
     * Atualiza os dados de matrícula de um aluno em uma turma existente.
     * 
     * @param AlunoTurmaId ID do registro de matrícula a ser atualizado.
     * @param uModel Objeto {@link AlunoTurmaModel} com os novos dados de matrícula.
     * @return O objeto {@link AlunoTurmaModel} atualizado.
     */
    @Transactional
    public AlunoTurmaModel update(String AlunoTurmaId, AlunoTurmaModel uModel) {
        AlunoTurmaModel AlunoTurma = read(AlunoTurmaId);

        Optional<AlunoModel> alunoOptional = AlunoRepository.findById(uModel.getAluno().getId());
        uModel.setAluno(alunoOptional.get());

        Optional<TurmaModel> turmaOptional = TurmaRepository.findById(uModel.getTurma().getId());
        uModel.setTurma(turmaOptional.get());

        AlunoTurmaRepository.save(AlunoTurma);
        return AlunoTurma;
    }
    
    /**
     * Exclui um registro de matrícula de aluno em uma turma pelo ID.
     * 
     * @param AlunoTurmaId ID do registro de matrícula a ser excluído.
     * @return O objeto {@link AlunoTurmaModel} que foi excluído.
     */
    @Transactional
    public AlunoTurmaModel delete(String AlunoTurmaId) {
        int parsedId = Integer.parseInt(AlunoTurmaId);
        AlunoTurmaModel AlunoTurmaToDelete = read(AlunoTurmaId);
        AlunoTurmaRepository.deleteById(parsedId);
        return AlunoTurmaToDelete;
    }
}
