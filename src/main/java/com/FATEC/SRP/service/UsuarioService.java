package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.UsuarioModel;
import com.fatec.srp.repositories.UsuarioRepository;

import java.util.List;

/**
 * Serviço responsável pelas operações CRUD relacionadas aos usuários.
 * 
 * Esta classe implementa a interface {@link IService} para fornecer as operações 
 * necessárias para gerenciar as entidades do tipo {@link UsuarioModel}.
 */
@Service
public class UsuarioService implements IService<UsuarioModel, String> {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    /**
     * Recupera todos os registros de usuários.
     * 
     * @return Lista de objetos do tipo {@link UsuarioModel}.
     */
    public List<UsuarioModel> read() {
        List<UsuarioModel> cList = UsuarioRepository.findAll();
        return cList;
    }

    /**
     * Recupera um registro específico de usuário com base no ID.
     * 
     * @param UsuarioId ID do usuário a ser recuperado.
     * @return Objeto do tipo {@link UsuarioModel} correspondente ao ID fornecido.
     */
    public UsuarioModel read(String UsuarioId) {
        int parsedId = Integer.parseInt(UsuarioId);
        UsuarioModel Usuario = UsuarioRepository.findById(parsedId).get();
        return Usuario;
    }

    /**
     * Cria um novo registro de usuário.
     * 
     * @param model Objeto contendo os dados para criação do novo registro.
     * @return O objeto do tipo {@link UsuarioModel} recém-criado.
     */
    @Transactional
    public UsuarioModel create(UsuarioModel model) {
        UsuarioModel Usuario = UsuarioRepository.save(model);
        return Usuario;
    }

    /**
     * Atualiza um registro de usuário existente.
     * 
     * @param UsuarioId ID do registro a ser atualizado.
     * @param uModel Objeto contendo os dados atualizados.
     * @return O objeto do tipo {@link UsuarioModel} atualizado.
     */
    @Transactional
    public UsuarioModel update(String UsuarioId, UsuarioModel uModel) {
        UsuarioModel Usuario = read(UsuarioId);

        Usuario.setNomePessoa(uModel.getNomePessoa());
        Usuario.setNomeSocial(uModel.getNomeSocial());
        Usuario.setNomeUsuario(uModel.getNomeUsuario());
        Usuario.setSenha(uModel.getSenha());

        UsuarioRepository.save(Usuario);
        return Usuario;
    }

    /**
     * Exclui um registro de usuário.
     * 
     * @param UsuarioId ID do registro a ser excluído.
     * @return O objeto do tipo {@link UsuarioModel} que foi excluído.
     */
    @Transactional
    public UsuarioModel delete(String UsuarioId) {
        int parsedId = Integer.parseInt(UsuarioId);
        UsuarioModel UsuarioToDelete = read(UsuarioId);
        UsuarioRepository.deleteById(parsedId);
        return UsuarioToDelete;
    }
}
