package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.PreRequisitoModel;
import com.fatec.srp.repositories.PreRequisitoRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações CRUD relacionadas aos pré-requisitos.
 * 
 * Esta classe implementa a interface {@link IService} para fornecer as operações 
 * necessárias para gerenciar as entidades do tipo {@link PreRequisitoModel}.
 * 
 * Conceitos OOP utilizados:
 * - **Herança**: A classe {@link PreRequisitoService} implementa a interface genérica {@link IService}, herdando seu contrato para operações CRUD.
 * - **Abstração**: A implementação das operações CRUD abstrai a lógica detalhada, permitindo que a interface forneça um comportamento comum para diferentes serviços.
 */
@Service
public class PreRequisitoService implements IService<PreRequisitoModel, String> {

    @Autowired
    private PreRequisitoRepository PreRequisitoRepository;

    /**
     * Recupera todos os registros de pré-requisitos.
     * 
     * @return Lista de objetos do tipo {@link PreRequisitoModel}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A operação de leitura dos registros é definida sem expor os detalhes de implementação.
     */
    public List<PreRequisitoModel> read() {
        List<PreRequisitoModel> cList = PreRequisitoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de pré-requisito com base no ID.
     * 
     * @param PreRequisitoId ID do pré-requisito a ser recuperado.
     * @return Objeto do tipo {@link PreRequisitoModel} correspondente ao ID fornecido.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A lógica de recuperação do registro é abstraída, permitindo que a interface permaneça simples.
     */
    public PreRequisitoModel read(String PreRequisitoId) {
        int parsedId = Integer.parseInt(PreRequisitoId);
        PreRequisitoModel PreRequisito = PreRequisitoRepository.findById(parsedId).get();
        return PreRequisito;
    }

    /**
     * Cria um novo registro de pré-requisito.
     * 
     * @param model Objeto contendo os dados para criação do novo registro.
     * @return O objeto do tipo {@link PreRequisitoModel} recém-criado.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de criação é encapsulado dentro do método, e a implementação é protegida, permitindo que a lógica interna não interfira com o comportamento do serviço.
     * - **Abstração**: A operação de persistir o registro no banco de dados é abstraída, deixando o serviço focado na criação do objeto.
     */
    @Transactional
    public PreRequisitoModel create(PreRequisitoModel model) {
        PreRequisitoModel PreRequisito = PreRequisitoRepository.save(model);
        return PreRequisito;
    }

    /**
     * Atualiza um registro de pré-requisito existente.
     * 
     * @param PreRequisitoId ID do registro a ser atualizado.
     * @param uModel Objeto contendo os dados atualizados.
     * @return O objeto do tipo {@link PreRequisitoModel} atualizado.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: Os detalhes da atualização do registro são encapsulados, permitindo que o serviço controle como o objeto é modificado.
     * - **Abstração**: A operação de atualizar os dados do pré-requisito é abstraída, tornando o código mais modular.
     */
    @Transactional
    public PreRequisitoModel update(String PreRequisitoId, PreRequisitoModel uModel) {
        PreRequisitoModel PreRequisito = read(PreRequisitoId);

        PreRequisito.setNomePrerequisito(uModel.getNomePrerequisito());
        PreRequisito.setDescPrerequisito(uModel.getDescPrerequisito());

        PreRequisitoRepository.save(PreRequisito);
        return PreRequisito;
    }

    /**
     * Exclui um registro de pré-requisito.
     * 
     * @param PreRequisitoId ID do registro a ser excluído.
     * @return O objeto do tipo {@link PreRequisitoModel} que foi excluído.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão do objeto é encapsulado dentro do método, tornando a implementação independente de outros componentes do sistema.
     * - **Abstração**: A exclusão é definida de forma abstrata, com a lógica interna sendo escondida, facilitando a manutenção e reutilização do código.
     */
    @Transactional
    public PreRequisitoModel delete(String PreRequisitoId) {
        int parsedId = Integer.parseInt(PreRequisitoId);
        PreRequisitoModel PreRequisitoToDelete = read(PreRequisitoId);
        PreRequisitoRepository.deleteById(parsedId);
        return PreRequisitoToDelete;
    }
}
