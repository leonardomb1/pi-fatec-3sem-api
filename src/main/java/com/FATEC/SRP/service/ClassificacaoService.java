package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.ClassificacaoModel;
import com.fatec.srp.repositories.ClassificacaoRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link ClassificacaoModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link ClassificacaoModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link ClassificacaoRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 */
@Service
public class ClassificacaoService implements IService<ClassificacaoModel, String> {

    @Autowired
    private ClassificacaoRepository ClassificacaoRepository;

    /**
     * Recupera todos os registros de classificações.
     * 
     * @return Lista de objetos {@link ClassificacaoModel}.
     */
    public List<ClassificacaoModel> read() {
        List<ClassificacaoModel> cList = ClassificacaoRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de classificação pelo seu ID.
     * 
     * @param classificacaoId ID da classificação.
     * @return Objeto {@link ClassificacaoModel} correspondente ao ID fornecido.
     */
    public ClassificacaoModel read(String classificacaoId) {
        int parsedId = Integer.parseInt(classificacaoId);
        ClassificacaoModel classificacao = ClassificacaoRepository.findById(parsedId).get();
        return classificacao;
    }
    
    /**
     * Cria uma nova classificação no banco de dados.
     * 
     * @param model Objeto {@link ClassificacaoModel} contendo os dados da nova classificação.
     * @return O objeto {@link ClassificacaoModel} persistido.
     */
    @Transactional
    public ClassificacaoModel create(ClassificacaoModel model) {
        ClassificacaoModel classificacao = ClassificacaoRepository.save(model);
        return classificacao;
    }
    
    /**
     * Atualiza os dados de uma classificação existente no banco de dados.
     * 
     * @param classificacaoId ID da classificação a ser atualizada.
     * @param uModel Objeto {@link ClassificacaoModel} com os novos dados da classificação.
     * @return O objeto {@link ClassificacaoModel} atualizado.
     */
    @Transactional
    public ClassificacaoModel update(String classificacaoId, ClassificacaoModel uModel) {
        ClassificacaoModel classificacao = read(classificacaoId);

        classificacao.setNomeClassificacao(uModel.getNomeClassificacao());

        ClassificacaoRepository.save(classificacao);
        return classificacao;
    }
    
    /**
     * Exclui uma classificação pelo ID.
     * 
     * @param classificacaoId ID da classificação a ser excluída.
     * @return O objeto {@link ClassificacaoModel} que foi excluído.
     */
    @Transactional
    public ClassificacaoModel delete(String classificacaoId) {
        int parsedId = Integer.parseInt(classificacaoId);
        ClassificacaoModel classificacaoToDelete = read(classificacaoId);
        ClassificacaoRepository.deleteById(parsedId);
        return classificacaoToDelete;
    }
}
