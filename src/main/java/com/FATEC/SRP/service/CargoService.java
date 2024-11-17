package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CargoModel;
import com.fatec.srp.repositories.CargoRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link CargoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link CargoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link CargoRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 *
 * Conceitos de OOP aplicados:
 * - **Encapsulamento**: A classe `CargoService` encapsula as operações relacionadas aos cargos, tornando o acesso e a manipulação de dados mais controlados e seguros.
 * - **Responsabilidade Única**: A classe segue o princípio de responsabilidade única, concentrando-se exclusivamente nas operações relacionadas aos cargos.
 * - **Injeção de Dependência**: O repositório `CargoRepository` é injetado automaticamente, promovendo a separação de responsabilidades e facilitando a manutenção do código.
 * - **Transações**: A anotação `@Transactional` garante que as operações de criação, atualização e exclusão de cargos sejam atômicas, garantindo a integridade dos dados.
 */
@Service
public class CargoService implements IService<CargoModel, String> {

    @Autowired
    private CargoRepository CargoRepository;

    /**
     * Recupera todos os registros de cargos.
     * 
     * @return Lista de objetos {@link CargoModel}.
     */
    public List<CargoModel> read() {
        List<CargoModel> cList = CargoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de cargo pelo seu ID.
     * 
     * @param cargoId ID do cargo.
     * @return Objeto {@link CargoModel} correspondente ao ID fornecido.
     */
    public CargoModel read(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargoModel cargo = CargoRepository.findById(parsedId).get();
        return cargo;
    }
    
    /**
     * Cria um novo cargo no banco de dados.
     * 
     * @param model Objeto {@link CargoModel} contendo os dados do novo cargo.
     * @return O objeto {@link CargoModel} persistido.
     */
    @Transactional
    public CargoModel create(CargoModel model) {
        CargoModel cargo = CargoRepository.save(model);
        return cargo;
    }
    
    /**
     * Atualiza os dados de um cargo existente no banco de dados.
     * 
     * @param cargoId ID do cargo a ser atualizado.
     * @param uModel Objeto {@link CargoModel} com os novos dados do cargo.
     * @return O objeto {@link CargoModel} atualizado.
     */
    @Transactional
    public CargoModel update(String cargoId, CargoModel uModel) {
        CargoModel cargo = read(cargoId);

        cargo.setNivelPermissao(uModel.getNivelPermissao());
        cargo.setNomeCargo(uModel.getNomeCargo());

        CargoRepository.save(cargo);
        return cargo;
    }
    
    /**
     * Exclui um cargo pelo ID.
     * 
     * @param cargoId ID do cargo a ser excluído.
     * @return O objeto {@link CargoModel} que foi excluído.
     */
    @Transactional
    public CargoModel delete(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargoModel cargoToDelete = read(cargoId);
        CargoRepository.deleteById(parsedId);
        return cargoToDelete;
    }
}
