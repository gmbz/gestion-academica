package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Materia;
import com.utn.gestionacademica.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() throws Exception {
        try {
            return materiaRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron materias", e);
        }
    }

    @Override
    public Materia findById(Materia materia) throws Exception {
        return materiaRepository.findById(materia.getId()).orElseThrow(() -> new Exception("No se encuentra la materia"));
    }

    @Override
    public Materia save(Materia materia) throws Exception {
        try {
            return materiaRepository.save(materia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Materia update(Materia materia) throws Exception {
        try {
            return materiaRepository.save(materia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Materia materia) throws Exception {
        try {
            materiaRepository.deleteById(materia.getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
