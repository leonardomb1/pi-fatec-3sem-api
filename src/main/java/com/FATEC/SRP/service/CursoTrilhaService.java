package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CursoTrilhaModel;
import com.fatec.srp.repositories.CursoTrilhaRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link CursoTrilhaModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link CursoTrilhaModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link CursoTrilhaRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 */
@Service
public class CursoTrilhaService implements IService<CursoTrilhaModel, String> {

    @Autowired
    private CursoTrilhaRepository CursoTrilhaRepository;

    /**
     * Recupera todos os cursos associados a trilhas.
     * 
     * @return Lista de objetos {@link CursoTrilhaModel}.
     */
    public List<CursoTrilhaModel> read() {
        List<CursoTrilhaModel> cList = CursoTrilhaRepository.findAll();
        return cList;
    }

    /**
     * Recupera um curso associado a uma trilha específica pelo seu ID.
     * 
     * @param CursoTrilhaId ID do curso-trilha.
     * @return Objeto {@link CursoTrilhaModel} correspondente ao ID fornecido.
     */
    public CursoTrilhaModel read(String CursoTrilhaId) {
        int parsedId = Integer.parseInt(CursoTrilhaId);
        CursoTrilhaModel CursoTrilha = CursoTrilhaRepository.findById(parsedId).get();
        return CursoTrilha;
    }
    
    /**
     * Cria uma nova associação de curso e trilha no banco de dados.
     * 
     * @param model Objeto {@link CursoTrilhaModel} contendo os dados da nova associação.
     * @return O objeto {@link CursoTrilhaModel} persistido.
     */
    @Transactional
    public CursoTrilhaModel create(CursoTrilhaModel model) {
        CursoTrilhaModel CursoTrilha = CursoTrilhaRepository.save(model);
        return CursoTrilha;
    }
    
    /**
     * Atualiza os dados de uma associação existente entre curso e trilha no banco de dados.
     * 
     * @param CursoTrilhaId ID da associação a ser atualizada.
     * @param uModel Objeto {@link CursoTrilhaModel} com os novos dados.
     * @return O objeto {@link CursoTrilhaModel} atualizado.
     */
    @Transactional
    public CursoTrilhaModel update(String CursoTrilhaId, CursoTrilhaModel uModel) {
        CursoTrilhaModel CursoTrilha = read(CursoTrilhaId);

        CursoTrilha.setTrilha(uModel.getTrilha());
        CursoTrilha.setCurso(uModel.getCurso());

        CursoTrilhaRepository.save(CursoTrilha);
        return CursoTrilha;
    }
    
    /**
     * Exclui uma associação entre curso e trilha pelo ID.
     * 
     * @param CursoTrilhaId ID da associação a ser excluída.
     * @return O objeto {@link CursoTrilhaModel} que foi excluído.
     */
    @Transactional
    public CursoTrilhaModel delete(String CursoTrilhaId) {
        int parsedId = Integer.parseInt(CursoTrilhaId);
        CursoTrilhaModel CursoTrilhaToDelete = read(CursoTrilhaId);
        CursoTrilhaRepository.deleteById(parsedId);
        return CursoTrilhaToDelete;
    }
}
