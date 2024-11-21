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
 * 
 * Conceitos OOP utilizados:
 * - **Herança**: A classe {@link UsuarioService} implementa a interface genérica {@link IService}, herdando seu contrato para operações CRUD.
 * - **Abstração**: A implementação das operações CRUD abstrai os detalhes de acesso ao banco de dados, permitindo uma interface limpa e reutilizável.
 * - **Encapsulamento**: O acesso e a manipulação dos usuários são encapsulados dentro dos métodos, mantendo o código organizado e modular.
 */
@Service
public class UsuarioService implements IService<UsuarioModel, String> {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    /**
     * Recupera todos os registros de usuários.
     * 
     * @return Lista de objetos do tipo {@link UsuarioModel}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A operação de leitura dos registros é abstraída, permitindo que a lógica interna de acesso aos dados seja oculta.
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
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A lógica de recuperação de um registro específico de usuário é definida de forma genérica, mantendo o foco apenas no que é necessário para o serviço.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: A criação do usuário é encapsulada dentro deste método, com a lógica de persistência protegida e abstraída.
     * - **Abstração**: A operação de persistência de dados é escondida, permitindo que o desenvolvedor interaja com um serviço mais simples.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: Os detalhes sobre a atualização do usuário são encapsulados neste método, deixando a interface do serviço limpa e fácil de usar.
     * - **Abstração**: A implementação da atualização é abstraída, com o desenvolvedor apenas fornecendo os dados que precisam ser alterados.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão do registro é encapsulado, mantendo a lógica de persistência oculta e o foco no serviço.
     * - **Abstração**: A operação de deletação é realizada de forma simplificada, com o usuário interagindo apenas com o serviço e sem detalhes sobre o funcionamento interno.
     */
    @Transactional
    public UsuarioModel delete(String UsuarioId) {
        int parsedId = Integer.parseInt(UsuarioId);
        UsuarioModel UsuarioToDelete = read(UsuarioId);
        UsuarioRepository.deleteById(parsedId);
        return UsuarioToDelete;
    }
}
