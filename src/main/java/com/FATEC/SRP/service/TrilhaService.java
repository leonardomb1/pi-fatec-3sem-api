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
 */
@Service
public class TrilhaService implements IService<TrilhaModel, String> {

    @Autowired
    private TrilhaRepository TrilhaRepository;

    /**
     * Recupera todos os registros de trilhas.
     * 
     * @return Lista de objetos do tipo {@link TrilhaModel}.
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
     */
    @Transactional
    public TrilhaModel delete(String TrilhaId) {
        int parsedId = Integer.parseInt(TrilhaId);
        TrilhaModel TrilhaToDelete = read(TrilhaId);
        TrilhaRepository.deleteById(parsedId);
        return TrilhaToDelete;
    }
}
