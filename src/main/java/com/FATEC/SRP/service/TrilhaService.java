package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.TrilhaModel;
import com.fatec.srp.repositories.TrilhaRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações CRUD relacionadas às trilhas.
 * 
 * Esta classe implementa a interface {@link IService} para fornecer as operações 
 * necessárias para gerenciar as entidades do tipo {@link TrilhaModel}.
 * 
 * Conceitos OOP utilizados:
 * - **Herança**: A classe {@link TrilhaService} implementa a interface genérica {@link IService}, herdando seu contrato para operações CRUD.
 * - **Abstração**: A implementação das operações CRUD abstrai a lógica detalhada, permitindo que a interface forneça um comportamento comum para diferentes serviços.
 */
@Service
public class TrilhaService implements IService<TrilhaModel, String> {

    @Autowired
    private TrilhaRepository TrilhaRepository;

    /**
     * Recupera todos os registros de trilhas.
     * 
     * @return Lista de objetos do tipo {@link TrilhaModel}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A operação de leitura dos registros é definida sem expor os detalhes de implementação.
     */
    public List<TrilhaModel> read() {
        List<TrilhaModel> cList = TrilhaRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de trilha com base no ID.
     * 
     * @param TrilhaId ID da trilha a ser recuperada.
     * @return Objeto do tipo {@link TrilhaModel} correspondente ao ID fornecido.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A lógica de recuperação do registro é abstraída, permitindo que a interface permaneça simples.
     */
    public TrilhaModel read(String TrilhaId) {
        int parsedId = Integer.parseInt(TrilhaId);
        TrilhaModel Trilha = TrilhaRepository.findById(parsedId).get();
        return Trilha;
    }

    /**
     * Cria um novo registro de trilha.
     * 
     * @param model Objeto contendo os dados para criação do novo registro.
     * @return O objeto do tipo {@link TrilhaModel} recém-criado.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de criação é encapsulado dentro do método, e a implementação é protegida, permitindo que a lógica interna não interfira com o comportamento do serviço.
     * - **Abstração**: A operação de persistir o registro no banco de dados é abstraída, deixando o serviço focado na criação do objeto.
     */
    @Transactional
    public TrilhaModel create(TrilhaModel model) {
        TrilhaModel Trilha = TrilhaRepository.save(model);
        return Trilha;
    }

    /**
     * Atualiza um registro de trilha existente.
     * 
     * @param TrilhaId ID do registro a ser atualizado.
     * @param uModel Objeto contendo os dados atualizados.
     * @return O objeto do tipo {@link TrilhaModel} atualizado.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: Os detalhes da atualização do registro são encapsulados, permitindo que o serviço controle como o objeto é modificado.
     * - **Abstração**: A operação de atualizar os dados da trilha é abstraída, tornando o código mais modular.
     */
    @Transactional
    public TrilhaModel update(String TrilhaId, TrilhaModel uModel) {
        TrilhaModel Trilha = read(TrilhaId);

        Trilha.setNomeTrilha(uModel.getNomeTrilha());
        Trilha.setDescTrilha(uModel.getDescTrilha());

        TrilhaRepository.save(Trilha);
        return Trilha;
    }

    /**
     * Exclui um registro de trilha.
     * 
     * @param TrilhaId ID do registro a ser excluído.
     * @return O objeto do tipo {@link TrilhaModel} que foi excluído.
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão do objeto é encapsulado dentro do método, tornando a implementação independente de outros componentes do sistema.
     * - **Abstração**: A exclusão é definida de forma abstrata, com a lógica interna sendo escondida, facilitando a manutenção e reutilização do código.
     */
    @Transactional
    public TrilhaModel delete(String TrilhaId) {
        int parsedId = Integer.parseInt(TrilhaId);
        TrilhaModel TrilhaToDelete = read(TrilhaId);
        TrilhaRepository.deleteById(parsedId);
        return TrilhaToDelete;
    }
}
