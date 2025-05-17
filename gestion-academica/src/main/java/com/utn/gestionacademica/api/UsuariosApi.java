package com.utn.gestionacademica.api;

import com.utn.gestionacademica.controller.UsuariosController;
import com.utn.gestionacademica.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/usuarios")
public class UsuariosApi {

    @Autowired
    private UsuariosController usuariosController;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No se encontraron usuarios"));
        }
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<?> getOne(@PathVariable("id_usuario") Long idUsuario) {
        try {
            Usuario usuario = new Usuario(idUsuario);
            return ResponseEntity.status(HttpStatus.OK).body(usuariosController.findById(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosController.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuariosController.update(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<?> delete(@PathVariable("id_usuario") Long idMethod) {
        try {
            Usuario usuario = new Usuario(idMethod);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuariosController.delete(usuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }
    
}
