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
import com.fatec.srp.models.UsuarioModel;
import com.fatec.srp.service.UsuarioService;

/**
 * Controlador para gerenciar os usuários.
 * Esta classe implementa os métodos de CRUD para os usuários, permitindo operações
 * de criação, leitura e atualização de usuários através da API.
 */
@RequestMapping("/api/usuario")
@RestController
public class UsuarioController implements IController<UsuarioModel, String> {
    
    @Autowired
    private UsuarioService usuarioService;
    
    /**
     * Recupera todos os usuários cadastrados.
     * 
     * @return ResponseEntity contendo a lista de usuários ou código de erro 404 se não encontrado.
     */
    @GetMapping 
    public ResponseEntity<ResponseBase<List<UsuarioModel>>> getAll() {
        List<UsuarioModel> lusuario = usuarioService.read();

        ResponseBase<List<UsuarioModel>> cBase = ResponseBase.<List<UsuarioModel>>builder()
            .error(false)
            .info("OK")
            .message(lusuario)
            .status(AppConstants.OK)
            .build();

        if(lusuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Recupera um usuário pelo seu ID.
     * 
     * @param usuarioId ID do usuário a ser recuperado.
     * @return ResponseEntity contendo o usuário ou código de erro 404 se não encontrado.
     */
    @GetMapping("/{usuarioId}")
    public ResponseEntity<ResponseBase<UsuarioModel>> getById(@PathVariable String usuarioId) {
        UsuarioModel usuario = usuarioService.read(usuarioId);

        ResponseBase<UsuarioModel> cBase = ResponseBase.<UsuarioModel>builder()
            .error(false)
            .info("OK")
            .message(usuario)
            .status(AppConstants.OK)
            .build();

        if(usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Cria um novo usuário.
     * 
     * @param usuario Objeto com os dados do usuário a ser criado.
     * @return ResponseEntity contendo o usuário criado ou código de erro 404 se não encontrado.
     */
    @PostMapping
    public ResponseEntity<ResponseBase<UsuarioModel>> getBody(@RequestBody UsuarioModel usuario) {
        usuarioService.create(usuario);

        ResponseBase<UsuarioModel> cBase = ResponseBase.<UsuarioModel>builder()
            .error(false)
            .info("OK")
            .message(usuario)
            .status(AppConstants.OK)
            .build();

        if(usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

    /**
     * Atualiza os dados de um usuário existente.
     * 
     * @param usuarioId ID do usuário a ser atualizado.
     * @param usuario Objeto com os novos dados do usuário.
     * @return ResponseEntity contendo o usuário atualizado ou código de erro 404 se não encontrado.
     */
    @PutMapping("/{usuarioId}")
    public ResponseEntity<ResponseBase<UsuarioModel>> update(@PathVariable String usuarioId, @RequestBody UsuarioModel usuario) {
        UsuarioModel uusuario = usuarioService.update(usuarioId, usuario);

        ResponseBase<UsuarioModel> cBase = ResponseBase.<UsuarioModel>builder()
            .error(false)
            .info("OK")
            .message(uusuario)
            .status(AppConstants.OK)
            .build();

        if(usuario == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cBase);
        }
    }

}
