package com.fatec.srp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.srp.common.AppConstants;
import com.fatec.srp.models.CargoModel;
import com.fatec.srp.service.CargoService;

@RequestMapping("/api/cargo")
@RestController
public class CargoController implements IController<CargoModel, String> {
    
    @Autowired
    private CargoService Cargoervice;
    
    @GetMapping 
    public ResponseEntity<ResponseBase<List<CargoModel>>> getAll() {
        List<CargoModel> lCargo = Cargoervice.read();

        ResponseBase<List<CargoModel>> cBase = ResponseBase.<List<CargoModel>>builder()
            .error(false)
            .info("OK")
            .message(lCargo)
            .status(AppConstants.OK)
            .build();

        if(lCargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @GetMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargoModel>> getById(@PathVariable String cargoId) {
        CargoModel cargo = Cargoervice.read(cargoId);

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(cargo)
            .status(AppConstants.OK)
            .build();

        if(cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseBase<CargoModel>> getBody(@RequestBody CargoModel cargo) {
        Cargoervice.create(cargo);

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(cargo)
            .status(AppConstants.OK)
            .build();

        if(cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    @PutMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargoModel>> update(@PathVariable String cargoId, @RequestBody CargoModel cargo) {
        CargoModel uCargo = Cargoervice.update(cargoId, cargo);

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(uCargo)
            .status(AppConstants.OK)
            .build();

        if(cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}