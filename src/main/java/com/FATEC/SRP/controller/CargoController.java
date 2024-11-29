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

/**
 * Controlador responsável por gerenciar as operações relacionadas aos cargos.
 * <p>
 * Implementa a interface IController para promover abstração e reutilização de código. 
 * Encapsula as regras de negócio no serviço CargoService, promovendo baixo acoplamento.
 * </p>
 */
@RequestMapping("/api/cargo")
@RestController
public class CargoController implements IController<CargoModel, String> {

    /**
     * Serviço de Cargo injetado automaticamente pelo Spring.
     * <p>
     * O uso de injeção de dependência favorece a inversão de controle e facilita testes unitários.
     * </p>
     */
    @Autowired
    private CargoService cargoService;

    /**
     * Recupera todos os cargos.
     * <p>
     * Demonstra abstração ao encapsular a lógica de negócio no serviço e encapsulamento ao organizar a resposta no objeto ResponseBase.
     * </p>
     * @return ResponseEntity contendo uma lista de CargoModel encapsulada em um ResponseBase.
     */
    @GetMapping
    public ResponseEntity<ResponseBase<List<CargoModel>>> getAll() {
        List<CargoModel> lCargo = cargoService.read();

        ResponseBase<List<CargoModel>> cBase = ResponseBase.<List<CargoModel>>builder()
            .error(false)
            .info("OK")
            .message(lCargo)
            .status(AppConstants.OK)
            .build();

        if (lCargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera um cargo específico pelo ID.
     * <p>
     * Implementa polimorfismo ao sobrescrever o método definido na interface IController.
     * </p>
     * @param cargoId O ID do cargo a ser recuperado.
     * @return ResponseEntity contendo um CargoModel encapsulado em um ResponseBase.
     */
    @GetMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargoModel>> getById(@PathVariable String cargoId) {
        CargoModel cargo = new CargoModel();
        
        try {
            cargo = cargoService.read(cargoId);
        } catch (Exception ex) {
            ResponseBase<CargoModel> noResult = ResponseBase.<CargoModel>builder()
                .error(false)
                .info("OK")
                .message(null)
                .status(AppConstants.OK)
                .build();
            return ResponseEntity.ok(noResult);
        }

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(cargo)
            .status(AppConstants.OK)
            .build();

        if (cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo cargo.
     * <p>
     * Encapsula os dados no modelo CargoModel e delega a lógica de persistência ao serviço.
     * </p>
     * @param cargo O CargoModel contendo os dados do novo cargo.
     * @return ResponseEntity contendo o CargoModel criado encapsulado em um ResponseBase.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<CargoModel>> getBody(@RequestBody CargoModel cargo) {
        cargoService.create(cargo);

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(cargo)
            .status(AppConstants.OK)
            .build();

        if (cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza um cargo existente.
     * <p>
     * Aplica abstração e reutilização ao delegar a lógica de atualização para o serviço CargoService.
     * </p>
     * @param cargoId O ID do cargo a ser atualizado.
     * @param cargo O CargoModel contendo os novos dados do cargo.
     * @return ResponseEntity contendo o CargoModel atualizado encapsulado em um ResponseBase.
     */
    @PutMapping("/{cargoId}")
    public ResponseEntity<ResponseBase<CargoModel>> update(@PathVariable String cargoId, @RequestBody CargoModel cargo) {
        CargoModel uCargo = cargoService.update(cargoId, cargo);

        ResponseBase<CargoModel> cBase = ResponseBase.<CargoModel>builder()
            .error(false)
            .info("OK")
            .message(uCargo)
            .status(AppConstants.OK)
            .build();

        if (cargo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
