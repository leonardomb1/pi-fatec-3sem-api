package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.EmpresaModel;
import com.fatec.srp.repositories.EmpresaRepository;

import java.util.List;

/**
 * Serviço que oferece operações de CRUD para a entidade {@link EmpresaModel}.
 * 
 * Este serviço realiza as operações básicas de persistência para a entidade {@link EmpresaModel},
 * como criar, ler, atualizar e excluir registros no banco de dados. Ele utiliza o repositório
 * {@link EmpresaRepository} para interagir com o banco de dados e é anotado com {@link Service},
 * tornando-se um componente gerenciado pelo Spring.
 * 
 * A classe também usa {@link Transactional} para garantir que as operações de atualização e exclusão
 * sejam realizadas de forma atômica e consistentes.
 */
@Service
public class EmpresaService implements IService<EmpresaModel, String> {

    @Autowired
    private EmpresaRepository EmpresaRepository;

    /**
     * Recupera todas as empresas.
     * 
     * @return Lista de objetos {@link EmpresaModel}.
     */
    public List<EmpresaModel> read() {
        List<EmpresaModel> cList = EmpresaRepository.findAll();
        return cList;
    }

    /**
     * Recupera uma empresa específica pelo seu ID.
     * 
     * @param EmpresaId ID da empresa.
     * @return Objeto {@link EmpresaModel} correspondente ao ID fornecido.
     */
    public EmpresaModel read(String EmpresaId) {
        int parsedId = Integer.parseInt(EmpresaId);
        EmpresaModel Empresa = EmpresaRepository.findById(parsedId).get();
        return Empresa;
    }
    
    /**
     * Cria uma nova empresa no banco de dados.
     * 
     * @param model Objeto {@link EmpresaModel} contendo os dados da nova empresa.
     * @return O objeto {@link EmpresaModel} persistido.
     */
    @Transactional
    public EmpresaModel create(EmpresaModel model) {
        EmpresaModel Empresa = EmpresaRepository.save(model);
        return Empresa;
    }
    
    /**
     * Atualiza os dados de uma empresa existente no banco de dados.
     * 
     * @param EmpresaId ID da empresa a ser atualizada.
     * @param uModel Objeto {@link EmpresaModel} com os novos dados.
     * @return O objeto {@link EmpresaModel} atualizado.
     */
    @Transactional
    public EmpresaModel update(String EmpresaId, EmpresaModel uModel) {
        EmpresaModel Empresa = read(EmpresaId);

        Empresa.setAgencia(uModel.getAgencia());
        Empresa.setBanco(uModel.getBanco());
        Empresa.setCnpj(uModel.getCnpj());
        Empresa.setEndereco(uModel.getEndereco());
        Empresa.setNomeFantasia(uModel.getNomeFantasia());
        Empresa.setRazaoSocial(uModel.getRazaoSocial());

        EmpresaRepository.save(Empresa);
        return Empresa;
    }
    
    /**
     * Exclui uma empresa pelo ID.
     * 
     * @param EmpresaId ID da empresa a ser excluída.
     * @return O objeto {@link EmpresaModel} que foi excluído.
     */
    @Transactional
    public EmpresaModel delete(String EmpresaId) {
        int parsedId = Integer.parseInt(EmpresaId);
        EmpresaModel EmpresaToDelete = read(EmpresaId);
        EmpresaRepository.deleteById(parsedId);
        return EmpresaToDelete;
    }
}
