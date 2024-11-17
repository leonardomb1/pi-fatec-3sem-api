package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.FuncionarioTurmaModel;
import com.fatec.srp.repositories.FuncionarioTurmaRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link FuncionarioTurmaModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link FuncionarioTurmaModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link FuncionarioTurmaRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 */
@Service
public class FuncionarioTurmaService implements IService<FuncionarioTurmaModel, String> {

    @Autowired
    private FuncionarioTurmaRepository FuncionarioTurmaRepository;

    /**
     * Recupera todos os registros de funcionários e turmas.
     * 
     * @return Lista de objetos {@link FuncionarioTurmaModel}.
     */
    public List<FuncionarioTurmaModel> read() {
        List<FuncionarioTurmaModel> cList = FuncionarioTurmaRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de funcionário e turma pelo ID.
     * 
     * @param FuncionarioTurmaId ID do registro de funcionário e turma.
     * @return Objeto {@link FuncionarioTurmaModel} correspondente ao ID fornecido.
     */
    public FuncionarioTurmaModel read(String FuncionarioTurmaId) {
        int parsedId = Integer.parseInt(FuncionarioTurmaId);
        FuncionarioTurmaModel FuncionarioTurma = FuncionarioTurmaRepository.findById(parsedId).get();
        return FuncionarioTurma;
    }
    
    /**
     * Cria um novo registro de funcionário e turma no banco de dados.
     * 
     * @param model Objeto {@link FuncionarioTurmaModel} contendo os dados do novo registro.
     * @return O objeto {@link FuncionarioTurmaModel} persistido.
     */
    @Transactional
    public FuncionarioTurmaModel create(FuncionarioTurmaModel model) {
        FuncionarioTurmaModel FuncionarioTurma = FuncionarioTurmaRepository.save(model);
        return FuncionarioTurma;
    }
    
    /**
     * Atualiza um registro existente de funcionário e turma no banco de dados.
     * 
     * @param FuncionarioTurmaId ID do registro a ser atualizado.
     * @param uModel Objeto {@link FuncionarioTurmaModel} com os novos dados.
     * @return O objeto {@link FuncionarioTurmaModel} atualizado.
     */
    @Transactional
    public FuncionarioTurmaModel update(String FuncionarioTurmaId, FuncionarioTurmaModel uModel) {
        FuncionarioTurmaModel FuncionarioTurma = read(FuncionarioTurmaId);

        FuncionarioTurma.setRazaoSocial(uModel.getRazaoSocial());
        FuncionarioTurma.setTurma(uModel.getTurma());
        FuncionarioTurma.setFuncionario(uModel.getFuncionario());

        FuncionarioTurmaRepository.save(FuncionarioTurma);
        return FuncionarioTurma;
    }
    
    /**
     * Exclui um registro de funcionário e turma pelo ID.
     * 
     * @param FuncionarioTurmaId ID do registro a ser excluído.
     * @return O objeto {@link FuncionarioTurmaModel} que foi excluído.
     */
    @Transactional
    public FuncionarioTurmaModel delete(String FuncionarioTurmaId) {
        int parsedId = Integer.parseInt(FuncionarioTurmaId);
        FuncionarioTurmaModel FuncionarioTurmaToDelete = read(FuncionarioTurmaId);
        FuncionarioTurmaRepository.deleteById(parsedId);
        return FuncionarioTurmaToDelete;
    }
}
