package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CursoClassificacaoModel;
import com.fatec.srp.repositories.CursoClassificacaoRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link CursoClassificacaoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link CursoClassificacaoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link CursoClassificacaoRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 */
@Service
public class CursoClassificacaoService implements IService<CursoClassificacaoModel, String> {

    @Autowired
    private CursoClassificacaoRepository CursoClassificacaoRepository;

    /**
     * Recupera todos os registros de curso e classificação.
     * 
     * @return Lista de objetos {@link CursoClassificacaoModel}.
     */
    public List<CursoClassificacaoModel> read() {
        List<CursoClassificacaoModel> cList = CursoClassificacaoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de curso e classificação pelo seu ID.
     * 
     * @param cursoClassificacaoId ID do curso e classificação.
     * @return Objeto {@link CursoClassificacaoModel} correspondente ao ID fornecido.
     */
    public CursoClassificacaoModel read(String cursoClassificacaoId) {
        int parsedId = Integer.parseInt(cursoClassificacaoId);
        CursoClassificacaoModel cursoClassificacao = CursoClassificacaoRepository.findById(parsedId).get();
        return cursoClassificacao;
    }
    
    /**
     * Cria um novo registro de curso e classificação no banco de dados.
     * 
     * @param model Objeto {@link CursoClassificacaoModel} contendo os dados do novo curso e classificação.
     * @return O objeto {@link CursoClassificacaoModel} persistido.
     */
    @Transactional
    public CursoClassificacaoModel create(CursoClassificacaoModel model) {
        CursoClassificacaoModel cursoClassificacao = CursoClassificacaoRepository.save(model);
        return cursoClassificacao;
    }
    
    /**
     * Atualiza os dados de um curso e classificação existente no banco de dados.
     * 
     * @param cursoClassificacaoId ID do curso e classificação a ser atualizado.
     * @param uModel Objeto {@link CursoClassificacaoModel} com os novos dados de curso e classificação.
     * @return O objeto {@link CursoClassificacaoModel} atualizado.
     */
    @Transactional
    public CursoClassificacaoModel update(String cursoClassificacaoId, CursoClassificacaoModel uModel) {
        CursoClassificacaoModel cursoClassificacao = read(cursoClassificacaoId);

        cursoClassificacao.setCurso(uModel.getCurso());
        cursoClassificacao.setClassificacao(uModel.getClassificacao());

        CursoClassificacaoRepository.save(cursoClassificacao);
        return cursoClassificacao;
    }
    
    /**
     * Exclui um curso e classificação pelo ID.
     * 
     * @param cursoClassificacaoId ID do curso e classificação a ser excluído.
     * @return O objeto {@link CursoClassificacaoModel} que foi excluído.
     */
    @Transactional
    public CursoClassificacaoModel delete(String cursoClassificacaoId) {
        int parsedId = Integer.parseInt(cursoClassificacaoId);
        CursoClassificacaoModel cursoClassificacaoToDelete = read(cursoClassificacaoId);
        CursoClassificacaoRepository.deleteById(parsedId);
        return cursoClassificacaoToDelete;
    }
}
