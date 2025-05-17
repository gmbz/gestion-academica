package com.utn.gestionacademica.controller;

import com.utn.gestionacademica.model.PlanEstudio;
import com.utn.gestionacademica.service.IMateriaService;
import com.utn.gestionacademica.service.IPlanEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanEstudioController {
    
    private final IPlanEstudioService planEstudioService;

    @Autowired
    public PlanEstudioController(IPlanEstudioService planEstudioService) {
        this.planEstudioService = planEstudioService;
    }

    public List<PlanEstudio> findAll() throws Exception {
        return planEstudioService.findAll();
    }

    public PlanEstudio findById(PlanEstudio plan) throws Exception {
        return planEstudioService.findById(plan);
    }

    public PlanEstudio save(PlanEstudio plan) throws Exception {
        return planEstudioService.save(plan);
    }

    public PlanEstudio update(PlanEstudio plan) throws Exception {
        return planEstudioService.update(plan);
    }

    public boolean delete(PlanEstudio plan) throws Exception {
        PlanEstudio planToDelete = planEstudioService.findById(plan);
        return planEstudioService.delete(planToDelete);
    }
}
