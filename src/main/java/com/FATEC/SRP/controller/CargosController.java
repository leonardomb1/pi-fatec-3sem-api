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
import com.fatec.srp.models.CargosModel;
import com.fatec.srp.service.CargosService;

/**
 * Controlador REST para gerenciar operações relacionadas a Cargos.
 * Implementa a interface IController para fornecer operações CRUD.
 * Utiliza o serviço CargosService para realizar as operações.
 */
@RequestMapping("/api/cargo")
@RestController
public class CargosController implements IController<CargosModel, String> {
    
    /**
     * Serviço de cargos injetado automaticamente pelo Spring.
     */
    @Autowired
    private CargosService cargoService;
    
    /**
     * Retorna todos os cargos.
     * 
     * @return ResponseEntity contendo a lista de todos os cargos e informações adicionais.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<CargosModel>>> getAll() {
        List<CargosModel> lCargo = cargoService.read();

        ResponseBase<List<CargosModel>> cBase = ResponseBase.<List<CargosModel>>builder()
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

    /**
     * Retorna um cargo específico pelo seu ID.
     * 
     * @param cargoId ID do cargo a ser retornado.
     * @return ResponseEntity contendo o cargo encontrado e informações adicionais.
     */
    @GetMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargosModel>> getById(@PathVariable String cargoId) {
        CargosModel cargo = cargoService.read(cargoId);

        ResponseBase<CargosModel> cBase = ResponseBase.<CargosModel>builder()
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

    /**
     * Cria um novo cargo.
     * 
     * @param cargo Objeto CargosModel contendo os dados do novo cargo.
     * @return ResponseEntity contendo o cargo criado e informações adicionais.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CargosModel>> getBody(@RequestBody CargosModel cargo) {
        cargoService.create(cargo);

        ResponseBase<CargosModel> cBase = ResponseBase.<CargosModel>builder()
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

    /**
     * Atualiza um cargo existente.
     * 
     * @param cargoId ID do cargo a ser atualizado.
     * @param cargo Objeto CargosModel contendo os novos dados do cargo.
     * @return ResponseEntity contendo o cargo atualizado e informações adicionais.
     */
    @PutMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargosModel>> update(@PathVariable String cargoId, @RequestBody CargosModel cargo) {
        CargosModel uCargo = cargoService.update(cargoId, cargo);

        ResponseBase<CargosModel> cBase = ResponseBase.<CargosModel>builder()
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