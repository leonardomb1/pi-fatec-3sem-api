package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.PreRequisitoCursoModel;
import com.fatec.srp.repositories.PreRequisitoCursoRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações CRUD relacionadas aos pré-requisitos de cursos.
 * 
 * Esta classe implementa a interface {@link IService} para fornecer as operações 
 * necessárias para gerenciar as entidades do tipo {@link PreRequisitoCursoModel}.
 */
@Service
public class PreRequisitoCursoService implements IService<PreRequisitoCursoModel, String> {

    @Autowired
    private PreRequisitoCursoRepository PreRequisitoCursoRepository;

    /**
     * Recupera todos os registros de pré-requisitos de cursos.
     * 
     * @return Lista de objetos do tipo {@link PreRequisitoCursoModel}.
     */
    public List<PreRequisitoCursoModel> read() {
        List<PreRequisitoCursoModel> cList = PreRequisitoCursoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de pré-requisito de curso com base no ID.
     * 
     * @param PreRequisitoCursoId ID do pré-requisito de curso a ser recuperado.
     * @return Objeto do tipo {@link PreRequisitoCursoModel} correspondente ao ID fornecido.
     */
    public PreRequisitoCursoModel read(String PreRequisitoCursoId) {
        int parsedId = Integer.parseInt(PreRequisitoCursoId);
        PreRequisitoCursoModel PreRequisitoCurso = PreRequisitoCursoRepository.findById(parsedId).get();
        return PreRequisitoCurso;
    }

    /**
     * Cria um novo registro de pré-requisito de curso.
     * 
     * @param model Objeto contendo os dados para criação do novo registro.
     * @return O objeto do tipo {@link PreRequisitoCursoModel} recém-criado.
     */
    @Transactional
    public PreRequisitoCursoModel create(PreRequisitoCursoModel model) {
        PreRequisitoCursoModel PreRequisitoCurso = PreRequisitoCursoRepository.save(model);
        return PreRequisitoCurso;
    }

    /**
     * Atualiza um registro de pré-requisito de curso existente.
     * 
     * @param PreRequisitoCursoId ID do registro a ser atualizado.
     * @param uModel Objeto contendo os dados atualizados.
     * @return O objeto do tipo {@link PreRequisitoCursoModel} atualizado.
     */
    @Transactional
    public PreRequisitoCursoModel update(String PreRequisitoCursoId, PreRequisitoCursoModel uModel) {
        PreRequisitoCursoModel PreRequisitoCurso = read(PreRequisitoCursoId);

        PreRequisitoCurso.setPreRequisito(uModel.getPreRequisito());
        PreRequisitoCurso.setCurso(uModel.getCurso());

        PreRequisitoCursoRepository.save(PreRequisitoCurso);
        return PreRequisitoCurso;
    }

    /**
     * Exclui um registro de pré-requisito de curso.
     * 
     * @param PreRequisitoCursoId ID do registro a ser excluído.
     * @return O objeto do tipo {@link PreRequisitoCursoModel} que foi excluído.
     */
    @Transactional
    public PreRequisitoCursoModel delete(String PreRequisitoCursoId) {
        int parsedId = Integer.parseInt(PreRequisitoCursoId);
        PreRequisitoCursoModel PreRequisitoCursoToDelete = read(PreRequisitoCursoId);
        PreRequisitoCursoRepository.deleteById(parsedId);
        return PreRequisitoCursoToDelete;
    }
}
