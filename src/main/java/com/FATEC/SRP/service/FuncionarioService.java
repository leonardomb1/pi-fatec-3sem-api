package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CargoModel;
import com.fatec.srp.models.FuncionarioModel;
import com.fatec.srp.models.UsuarioModel;
import com.fatec.srp.repositories.CargoRepository;
import com.fatec.srp.repositories.FuncionarioRepository;
import com.fatec.srp.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link FuncionarioModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link FuncionarioModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link FuncionarioRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `FuncionarioService` encapsula a lógica de manipulação dos dados de funcionários e turmas, oferecendo uma interface controlada para as operações de CRUD. Ela interage com o repositório para a persistência, mantendo a lógica de acesso aos dados separada do resto da aplicação.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única ao se concentrar apenas nas operações de CRUD relacionadas à entidade `FuncionarioModel`. O repositório é responsável pela persistência, enquanto a classe `FuncionarioService` cuida da lógica de aplicação, como validações e operações transacionais.
 * - **Injeção de Dependência**: O repositório `FuncionarioRepository` é injetado automaticamente pelo Spring através da anotação `@Autowired`. Isso permite que a classe utilize as funcionalidades do repositório sem a necessidade de instanciá-lo manualmente, promovendo o desacoplamento entre as classes.
 * - **Transações**: A anotação `@Transactional` assegura que as operações de CRUD (criação, atualização e exclusão de registros de funcionário e turma) sejam realizadas dentro de uma transação. Isso garante a integridade dos dados e permite a reversão das operações em caso de falha, assegurando que o banco de dados permaneça em um estado consistente.
 */
@Service
public class FuncionarioService implements IService<FuncionarioModel, String> {

    @Autowired
    private CargoRepository cargoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private FuncionarioRepository FuncionarioRepository;

    /**
     * Recupera todos os registros de funcionários e turmas.
     * 
     * @return Lista de objetos {@link FuncionarioModel}.
     */
    public List<FuncionarioModel> read() {
        List<FuncionarioModel> cList = FuncionarioRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de funcionário e turma pelo ID.
     * 
     * @param funcionarioId ID do registro de funcionário e turma.
     * @return Objeto {@link FuncionarioModel} correspondente ao ID fornecido.
     */
    public FuncionarioModel read(String funcionarioId) {
        int parsedId = Integer.parseInt(funcionarioId);
        FuncionarioModel funcionario = FuncionarioRepository.findById(parsedId).get();
        return funcionario;
    }
    
    /**
     * Cria um novo registro de funcionário e turma no banco de dados.
     * 
     * @param model Objeto {@link FuncionarioModel} contendo os dados do novo registro.
     * @return O objeto {@link FuncionarioModel} persistido.
     */
    @Transactional
    public FuncionarioModel create(FuncionarioModel model) {

        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(model.getUsuario().getId());
        model.setUsuario(usuarioOptional.get());

        Optional<CargoModel> cargoOptional = cargoRepository.findById(model.getCargo().getId());
        model.setCargo(cargoOptional.get());

        return FuncionarioRepository.save(model);
    }
    
    /**
     * Atualiza um registro existente de funcionário e turma no banco de dados.
     * 
     * @param funcionarioId ID do registro a ser atualizado.
     * @param uModel Objeto {@link FuncionarioModel} com os novos dados.
     * @return O objeto {@link FuncionarioModel} atualizado.
     */
    @Transactional
    public FuncionarioModel update(String funcionarioId, FuncionarioModel uModel) {
        FuncionarioModel funcionario = read(funcionarioId);

        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(uModel.getUsuario().getId());
        funcionario.setUsuario(usuarioOptional.get());

        Optional<CargoModel> cargoOptional = cargoRepository.findById(uModel.getCargo().getId());
        funcionario.setCargo(cargoOptional.get());

        FuncionarioRepository.save(funcionario);
        return funcionario;
    }
    
    /**
     * Exclui um registro de funcionário e turma pelo ID.
     * 
     * @param funcionarioId ID do registro a ser excluído.
     * @return O objeto {@link FuncionarioModel} que foi excluído.
     */
    @Transactional
    public FuncionarioModel delete(String funcionarioId) {
        int parsedId = Integer.parseInt(funcionarioId);
        FuncionarioModel funcionarioToDelete = read(funcionarioId);
        FuncionarioRepository.deleteById(parsedId);
        return funcionarioToDelete;
    }
}
