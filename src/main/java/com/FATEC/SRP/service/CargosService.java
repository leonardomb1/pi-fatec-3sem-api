package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CargosModel;
import com.fatec.srp.repositories.CargosRepository;

import java.util.List;

@Service
public class CargosService implements IService<CargosModel, String> {

    @Autowired
    private CargosRepository cargosRepository;

    public List<CargosModel> read() {
        List<CargosModel> cList = cargosRepository.findAll();
        return cList;
    }

    public CargosModel read(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargosModel cargo = cargosRepository.findById(parsedId).get();
        return cargo;
    }
    
    @Transactional
    public CargosModel create(CargosModel model) {
        CargosModel cargo = cargosRepository.save(model);
        return cargo;
    }
    
    @Transactional
    public CargosModel update(String cargoId, CargosModel uModel) {
        CargosModel cargo = read(cargoId);

        cargo.setNivelPermissao(uModel.getNivelPermissao());
        cargo.setNomeCargo(uModel.getNomeCargo());

        cargosRepository.save(cargo);
        return cargo;
    }
    
    @Transactional
    public CargosModel delete(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargosModel cargoToDelete = read(cargoId);
        cargosRepository.deleteById(parsedId);
        return cargoToDelete;
    }
}
