package com.utn.gestionacademica.controller;

import com.utn.gestionacademica.model.Materia;
import com.utn.gestionacademica.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MateriaController {

    private final IMateriaService materiaService;
    
    @Autowired
    public MateriaController(IMateriaService materiaService) {
        this.materiaService = materiaService;
    }

    public List<Materia> findAll() throws Exception {
        return materiaService.findAll();
    }

    public Materia findById(Materia materia) throws Exception {
        return materiaService.findById(materia);
    }

    public Materia save(Materia materia) throws Exception {
        return this.findById(materiaService.save(materia));
    }

    public Materia update(Materia materia) throws Exception {
        return materiaService.update(materia);
    }

    public boolean delete(Materia materia) throws Exception {
        Materia materiaToDelete = materiaService.findById(materia);
        return materiaService.delete(materiaToDelete);
    }

    public List<Materia> saveMany(List<Materia> materias) throws Exception {
        List<Materia> savedMaterias = new ArrayList<>();
        for (Materia materia : materias) {
            savedMaterias.add(materiaService.save(materia));
        }
        return savedMaterias;
    }
    
}
