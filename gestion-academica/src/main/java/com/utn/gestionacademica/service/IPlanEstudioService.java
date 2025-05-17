package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.PlanEstudio;

import java.util.List;

public interface IPlanEstudioService {

    public List<PlanEstudio> findAll() throws Exception;

    public PlanEstudio findById(PlanEstudio plan) throws Exception;

    public PlanEstudio save(PlanEstudio plan) throws Exception;

    public PlanEstudio update(PlanEstudio plan) throws Exception;

    public boolean delete(PlanEstudio plan) throws Exception;

}
