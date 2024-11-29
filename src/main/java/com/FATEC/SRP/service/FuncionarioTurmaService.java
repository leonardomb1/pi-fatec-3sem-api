package com.fatec.srp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.FuncionarioModel;
import com.fatec.srp.models.FuncionarioTurmaModel;
import com.fatec.srp.models.TurmaModel;
import com.fatec.srp.repositories.FuncionarioRepository;
import com.fatec.srp.repositories.FuncionarioTurmaRepository;
import com.fatec.srp.repositories.TurmaRepository;

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
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `FuncionarioTurmaService` encapsula a lógica de manipulação dos dados de funcionários e turmas, oferecendo uma interface controlada para as operações de CRUD. Ela interage com o repositório para a persistência, mantendo a lógica de acesso aos dados separada do resto da aplicação.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única ao se concentrar apenas nas operações de CRUD relacionadas à entidade `FuncionarioTurmaModel`. O repositório é responsável pela persistência, enquanto a classe `FuncionarioTurmaService` cuida da lógica de aplicação, como validações e operações transacionais.
 * - **Injeção de Dependência**: O repositório `FuncionarioTurmaRepository` é injetado automaticamente pelo Spring através da anotação `@Autowired`. Isso permite que a classe utilize as funcionalidades do repositório sem a necessidade de instanciá-lo manualmente, promovendo o desacoplamento entre as classes.
 * - **Transações**: A anotação `@Transactional` assegura que as operações de CRUD (criação, atualização e exclusão de registros de funcionário e turma) sejam realizadas dentro de uma transação. Isso garante a integridade dos dados e permite a reversão das operações em caso de falha, assegurando que o banco de dados permaneça em um estado consistente.
 */
@Service
public class FuncionarioTurmaService implements IService<FuncionarioTurmaModel, String> {

    @Autowired
    private FuncionarioTurmaRepository FuncionarioTurmaRepository;

    @Autowired
    private FuncionarioRepository FuncionarioRepository;

    @Autowired
    private TurmaRepository TurmaRepository;

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

        Optional<FuncionarioModel> funcionarioOptional = FuncionarioRepository.findById(model.getFuncionario().getId());
        model.setFuncionario(funcionarioOptional.get());

        Optional<TurmaModel> turmaOptional = TurmaRepository.findById(model.getTurma().getId());
        model.setTurma(turmaOptional.get());

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

        Optional<FuncionarioModel> funcionarioOptional = FuncionarioRepository.findById(uModel.getFuncionario().getId());
        uModel.setFuncionario(funcionarioOptional.get());

        Optional<TurmaModel> turmaOptional = TurmaRepository.findById(uModel.getTurma().getId());
        uModel.setTurma(turmaOptional.get());

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
