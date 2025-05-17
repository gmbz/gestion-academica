package com.utn.gestionacademica.api;

import com.utn.gestionacademica.controller.EventosController;
import com.utn.gestionacademica.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/eventos")
public class EventosApi {
    
    @Autowired
    private EventosController eventosController;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventosController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No se encontraron eventos"));
        }
    }

    @GetMapping("/{id_evento}")
    public ResponseEntity<?> getOne(@PathVariable("id_evento") Long idEvento) {
        try {
            Evento evento = new Evento(idEvento);
            return ResponseEntity.status(HttpStatus.OK).body(eventosController.findById(evento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "error"));
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Evento evento) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventosController.save(evento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Evento evento) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventosController.update(evento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }

    @DeleteMapping("/{id_evento}")
    public ResponseEntity<?> delete(@PathVariable("id_evento") Long idMethod) {
        try {
            Evento evento = new Evento(idMethod);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(eventosController.delete(evento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "error"));
        }
    }
    
}
