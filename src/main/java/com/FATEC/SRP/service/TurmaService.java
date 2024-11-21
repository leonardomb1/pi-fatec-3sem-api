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
 * 
 * Conceitos OOP utilizados:
 * - **Herança**: A classe {@link TurmaService} implementa a interface genérica {@link IService}, herdando seu contrato para operações CRUD.
 * - **Abstração**: A implementação das operações CRUD abstrai os detalhes de acesso ao banco de dados, permitindo uma interface limpa e reutilizável.
 * - **Encapsulamento**: O acesso e a manipulação das turmas são encapsulados dentro dos métodos, mantendo o código organizado e modular.
 */
@Service
public class TurmaService implements IService<TurmaModel, String> {

    @Autowired
    private TurmaRepository TurmaRepository;

    /**
     * Recupera todos os registros de turmas.
     * 
     * @return Lista de objetos do tipo {@link TurmaModel}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A operação de leitura dos registros é abstraída, permitindo que a lógica interna de acesso aos dados seja oculta.
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
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A lógica de recuperação de um registro específico de turma é definida de forma genérica, mantendo o foco apenas no que é necessário para o serviço.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: A criação da turma é encapsulada dentro deste método, com a lógica de persistência protegida e abstraída.
     * - **Abstração**: A operação de persistência de dados é escondida, permitindo que o desenvolvedor interaja com um serviço mais simples.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: Os detalhes sobre a atualização da turma são encapsulados neste método, deixando a interface do serviço limpa e fácil de usar.
     * - **Abstração**: A implementação da atualização é abstraída, com o desenvolvedor apenas fornecendo os dados que precisam ser alterados.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão do registro é encapsulado, mantendo a lógica de persistência oculta e o foco no serviço.
     * - **Abstração**: A operação de deletação é realizada de forma simplificada, com o usuário interagindo apenas com o serviço e sem detalhes sobre o funcionamento interno.
     */
    @Transactional
    public TurmaModel delete(String TurmaId) {
        int parsedId = Integer.parseInt(TurmaId);
        TurmaModel TurmaToDelete = read(TurmaId);
        TurmaRepository.deleteById(parsedId);
        return TurmaToDelete;
    }
}
