package com.utn.gestionacademica.api;

import com.utn.gestionacademica.controller.MateriaController;
import com.utn.gestionacademica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/materias")
public class MateriaApi {

    @Autowired
    private MateriaController materiaController;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No se encontraron materias"));
        }
    }

    @GetMapping("/{id_materia}")
    public ResponseEntity<?> getOne(@PathVariable("id_materia") Long idMateria) {
        try {
            Materia materia = new Materia(idMateria);
            return ResponseEntity.status(HttpStatus.OK).body(materiaController.findById(materia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Materia materia) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaController.save(materia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Materia materia) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaController.update(materia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @DeleteMapping("/{id_materia}")
    public ResponseEntity<?> delete(@PathVariable("id_materia") Long idMethod) {
        try {
            Materia materia = new Materia(idMethod);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(materiaController.delete(materia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PostMapping("/save_many")
    public ResponseEntity<?> saveMany(@RequestBody List<Materia> materia) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaController.saveMany(materia));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

}
