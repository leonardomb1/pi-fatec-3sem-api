package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.AlunoModel;
import com.fatec.srp.repositories.AlunoRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link AlunoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link AlunoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link AlunoRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `AlunoService` encapsula as operações de persistência e lógica de negócios, expondo métodos simples para interagir com a base de dados.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única, pois é responsável exclusivamente por realizar operações relacionadas aos alunos.
 * - **Injeção de Dependência**: O repositório `AlunoRepository` é injetado automaticamente, promovendo a separação de responsabilidades e facilitando a manutenção.
 * - **Transações**: A anotação `@Transactional` garante que as operações de criação, atualização e exclusão sejam atômicas, ou seja, ou todas as alterações são aplicadas com sucesso ou, em caso de erro, nenhuma alteração é realizada.
 */
@Service
public class AlunoService implements IService<AlunoModel, String> {

    @Autowired
    private AlunoRepository AlunoRepository;

    /**
     * Recupera todos os alunos registrados no banco de dados.
     * 
     * @return Lista de objetos {@link AlunoModel}.
     */
    public List<AlunoModel> read() {
        List<AlunoModel> cList = AlunoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um aluno específico pelo seu ID.
     * 
     * @param AlunoId ID do aluno.
     * @return Objeto {@link AlunoModel} correspondente ao ID fornecido.
     */
    public AlunoModel read(String AlunoId) {
        int parsedId = Integer.parseInt(AlunoId);
        AlunoModel Aluno = AlunoRepository.findById(parsedId).get();
        return Aluno;
    }
    
    /**
     * Cria um novo aluno no banco de dados.
     * 
     * @param model Objeto {@link AlunoModel} contendo os dados do aluno a ser criado.
     * @return O objeto {@link AlunoModel} persistido.
     */
    @Transactional
    public AlunoModel create(AlunoModel model) {
        AlunoModel Aluno = AlunoRepository.save(model);
        return Aluno;
    }
    
    /**
     * Atualiza os dados de um aluno existente.
     * 
     * @param AlunoId ID do aluno a ser atualizado.
     * @param uModel Objeto {@link AlunoModel} com os novos dados.
     * @return O objeto {@link AlunoModel} atualizado.
     */
    @Transactional
    public AlunoModel update(String AlunoId, AlunoModel uModel) {
        AlunoModel Aluno = read(AlunoId);

        Aluno.setAgencia(uModel.getAgencia());
        Aluno.setBanco(uModel.getBanco());
        Aluno.setCandidato(uModel.getCandidato());
        Aluno.setCpf(uModel.getCpf());
        Aluno.setDescricaoPcd(uModel.getDescricaoPcd());
        Aluno.setDtNascimento(uModel.getDtNascimento());
        Aluno.setEmpresa(uModel.getEmpresa());
        Aluno.setEndereco(uModel.getEndereco());
        Aluno.setNivelEscolaridade(uModel.getNivelEscolaridade());
        Aluno.setPcd(uModel.getPcd());
        Aluno.setRg(uModel.getRg());
        Aluno.setTurmaAluno(uModel.getTurmaAluno());
        Aluno.setUsuario(uModel.getUsuario());

        AlunoRepository.save(Aluno);
        return Aluno;
    }
    
    /**
     * Exclui um aluno do banco de dados pelo ID.
     * 
     * @param AlunoId ID do aluno a ser excluído.
     * @return O objeto {@link AlunoModel} que foi excluído.
     */
    @Transactional
    public AlunoModel delete(String AlunoId) {
        int parsedId = Integer.parseInt(AlunoId);
        AlunoModel AlunoToDelete = read(AlunoId);
        AlunoRepository.deleteById(parsedId);
        return AlunoToDelete;
    }
}
