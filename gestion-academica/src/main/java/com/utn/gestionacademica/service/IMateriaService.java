package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Materia;

import java.util.List;

public interface IMateriaService {

    public List<Materia> findAll() throws Exception;

    public Materia findById(Materia materia) throws Exception;

    public Materia save(Materia materia) throws Exception;

    public Materia update(Materia materia) throws Exception;

    public boolean delete(Materia materia) throws Exception;
    
}
