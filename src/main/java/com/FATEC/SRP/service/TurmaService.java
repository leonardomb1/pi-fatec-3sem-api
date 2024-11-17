package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.TurmaModel;
import com.fatec.srp.repositories.TurmaRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações CRUD relacionadas às turmas.
 * 
 * Esta classe implementa a interface {@link IService} para fornecer as operações 
 * necessárias para gerenciar as entidades do tipo {@link TurmaModel}.
 */
@Service
public class TurmaService implements IService<TurmaModel, String> {

    @Autowired
    private TurmaRepository TurmaRepository;

    /**
     * Recupera todos os registros de turmas.
     * 
     * @return Lista de objetos do tipo {@link TurmaModel}.
     */
    public List<TurmaModel> read() {
        List<TurmaModel> cList = TurmaRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de turma com base no ID.
     * 
     * @param TurmaId ID da turma a ser recuperada.
     * @return Objeto do tipo {@link TurmaModel} correspondente ao ID fornecido.
     */
    public TurmaModel read(String TurmaId) {
        int parsedId = Integer.parseInt(TurmaId);
        TurmaModel Turma = TurmaRepository.findById(parsedId).get();
        return Turma;
    }

    /**
     * Cria um novo registro de turma.
     * 
     * @param model Objeto contendo os dados para criação do novo registro.
     * @return O objeto do tipo {@link TurmaModel} recém-criado.
     */
    @Transactional
    public TurmaModel create(TurmaModel model) {
        TurmaModel Turma = TurmaRepository.save(model);
        return Turma;
    }

    /**
     * Atualiza um registro de turma existente.
     * 
     * @param TurmaId ID do registro a ser atualizado.
     * @param uModel Objeto contendo os dados atualizados.
     * @return O objeto do tipo {@link TurmaModel} atualizado.
     */
    @Transactional
    public TurmaModel update(String TurmaId, TurmaModel uModel) {
        TurmaModel Turma = read(TurmaId);

        Turma.setPeriodo(uModel.getPeriodo());
        Turma.setDataInicio(uModel.getDataInicio());
        Turma.setDataFim(uModel.getDataFim());
        Turma.setCurso(uModel.getCurso());

        TurmaRepository.save(Turma);
        return Turma;
    }

    /**
     * Exclui um registro de turma.
     * 
     * @param TurmaId ID do registro a ser excluído.
     * @return O objeto do tipo {@link TurmaModel} que foi excluído.
     */
    @Transactional
    public TurmaModel delete(String TurmaId) {
        int parsedId = Integer.parseInt(TurmaId);
        TurmaModel TurmaToDelete = read(TurmaId);
        TurmaRepository.deleteById(parsedId);
        return TurmaToDelete;
    }
}
