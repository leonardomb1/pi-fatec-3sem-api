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
 * 
 * Conceitos OOP utilizados:
 * - **Herança**: A classe {@link PreRequisitoCursoService} implementa a interface genérica {@link IService}, herdando seu contrato para operações CRUD.
 * - **Abstração**: A implementação das operações CRUD abstrai a lógica detalhada, permitindo que a interface forneça um comportamento comum para diferentes serviços.
 */
@Service
public class PreRequisitoCursoService implements IService<PreRequisitoCursoModel, String> {

    @Autowired
    private PreRequisitoCursoRepository PreRequisitoCursoRepository;

    /**
     * Recupera todos os registros de pré-requisitos de cursos.
     * 
     * @return Lista de objetos do tipo {@link PreRequisitoCursoModel}.
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A operação de leitura dos registros é definida sem expor os detalhes de implementação.
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
     * 
     * Conceitos OOP utilizados:
     * - **Abstração**: A lógica de recuperação do registro é abstraída, permitindo que a interface permaneça simples.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de criação é encapsulado dentro do método, e a implementação é protegida, permitindo que a lógica interna não interfira com o comportamento do serviço.
     * - **Abstração**: A operação de persistir o registro no banco de dados é abstraída, deixando o serviço focado na criação do objeto.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: Os detalhes da atualização do registro são encapsulados, permitindo que o serviço controle como o objeto é modificado.
     * - **Abstração**: A operação de atualizar os dados do pré-requisito do curso é abstraída, tornando o código mais modular.
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
     * 
     * Conceitos OOP utilizados:
     * - **Encapsulamento**: O processo de exclusão do objeto é encapsulado dentro do método, tornando a implementação independente de outros componentes do sistema.
     * - **Abstração**: A exclusão é definida de forma abstrata, com a lógica interna sendo escondida, facilitando a manutenção e reutilização do código.
     */
    @Transactional
    public PreRequisitoCursoModel delete(String PreRequisitoCursoId) {
        int parsedId = Integer.parseInt(PreRequisitoCursoId);
        PreRequisitoCursoModel PreRequisitoCursoToDelete = read(PreRequisitoCursoId);
        PreRequisitoCursoRepository.deleteById(parsedId);
        return PreRequisitoCursoToDelete;
    }
}
