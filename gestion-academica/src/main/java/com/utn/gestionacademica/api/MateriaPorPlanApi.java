package com.utn.gestionacademica.api;

import com.utn.gestionacademica.controller.MateriaPorPlanController;
import com.utn.gestionacademica.model.MateriaPorPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/materias_por_plan")
public class MateriaPorPlanApi {

    @Autowired
    private MateriaPorPlanController materiaPorPlanController;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaPorPlanController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No se encontraron materias"));
        }
    }

    @GetMapping("/{id_materia_por_plan}")
    public ResponseEntity<?> getOne(@PathVariable("id_materia_por_plan") Long idMateriaPorPlan) {
        try {
            MateriaPorPlan materiaPorPlan = new MateriaPorPlan(idMateriaPorPlan);
            return ResponseEntity.status(HttpStatus.OK).body(materiaPorPlanController.findById(materiaPorPlan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody MateriaPorPlan materiaPorPlan) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaPorPlanController.save(materiaPorPlan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody MateriaPorPlan materiaPorPlan) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(materiaPorPlanController.update(materiaPorPlan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @DeleteMapping("/{id_materia_por_plan}")
    public ResponseEntity<?> delete(@PathVariable("id_materia_por_plan") Long idMateriaPorPlan) {
        try {
            MateriaPorPlan materiaPorPlan = new MateriaPorPlan(idMateriaPorPlan);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(materiaPorPlanController.delete(materiaPorPlan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }
}
