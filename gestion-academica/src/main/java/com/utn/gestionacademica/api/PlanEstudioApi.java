package com.utn.gestionacademica.api;

import com.utn.gestionacademica.controller.PlanEstudioController;
import com.utn.gestionacademica.model.PlanEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/plan_estudio")
public class PlanEstudioApi {

    @Autowired
    private PlanEstudioController planEstudioController;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @GetMapping("/{id_plan}")
    public ResponseEntity<?> getOne(@PathVariable("id_plan") Long idPlan) {
        try {
            PlanEstudio planEstudio = new PlanEstudio(idPlan);
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioController.findById(planEstudio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PlanEstudio planEstudio) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioController.save(planEstudio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody PlanEstudio planEstudio) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioController.update(planEstudio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @DeleteMapping("/{id_plan}")
    public ResponseEntity<?> delete(@PathVariable("id_plan") Long idMethod) {
        try {
            PlanEstudio planEstudio = new PlanEstudio(idMethod);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(planEstudioController.delete(planEstudio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }
    
}
