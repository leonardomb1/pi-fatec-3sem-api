package com.fatec.srp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.srp.models.CargoModel;
import com.fatec.srp.repositories.CargoRepository;

import java.util.List;

@Service
public class CargoService implements IService<CargoModel, String> {

    @Autowired
    private CargoRepository CargoRepository;

    public List<CargoModel> read() {
        List<CargoModel> cList = CargoRepository.findAll();
        return cList;
    }

    public CargoModel read(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargoModel cargo = CargoRepository.findById(parsedId).get();
        return cargo;
    }
    
    @Transactional
    public CargoModel create(CargoModel model) {
        CargoModel cargo = CargoRepository.save(model);
        return cargo;
    }
    
    @Transactional
    public CargoModel update(String cargoId, CargoModel uModel) {
        CargoModel cargo = read(cargoId);

        cargo.setNivelPermissao(uModel.getNivelPermissao());
        cargo.setNomeCargo(uModel.getNomeCargo());

        CargoRepository.save(cargo);
        return cargo;
    }
    
    @Transactional
    public CargoModel delete(String cargoId) {
        int parsedId = Integer.parseInt(cargoId);
        CargoModel cargoToDelete = read(cargoId);
        CargoRepository.deleteById(parsedId);
        return cargoToDelete;
    }
}
