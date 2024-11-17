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
 */
@Service
public class PreRequisitoService implements IService<PreRequisitoModel, String> {

    @Autowired
    private PreRequisitoRepository PreRequisitoRepository;

    /**
     * Recupera todos os registros de pré-requisitos.
     * 
     * @return Lista de objetos do tipo {@link PreRequisitoModel}.
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
     */
    @Transactional
    public PreRequisitoModel delete(String PreRequisitoId) {
        int parsedId = Integer.parseInt(PreRequisitoId);
        PreRequisitoModel PreRequisitoToDelete = read(PreRequisitoId);
        PreRequisitoRepository.deleteById(parsedId);
        return PreRequisitoToDelete;
    }
}
