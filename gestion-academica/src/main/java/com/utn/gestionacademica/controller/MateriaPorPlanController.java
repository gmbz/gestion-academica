package com.utn.gestionacademica.controller;

import com.utn.gestionacademica.model.MateriaPorPlan;
import com.utn.gestionacademica.service.IMateriaPorPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MateriaPorPlanController {

    private final IMateriaPorPlanService materiaPorPlanService;

    @Autowired
    public MateriaPorPlanController(IMateriaPorPlanService materiaPorPlanService) {
        this.materiaPorPlanService = materiaPorPlanService;
    }

    public List<MateriaPorPlan> findAll() throws Exception {
        return materiaPorPlanService.findAll();
    }

    public MateriaPorPlan findById(MateriaPorPlan materiaPorPlan) throws Exception {
        return materiaPorPlanService.findById(materiaPorPlan);
    }

    public MateriaPorPlan save(MateriaPorPlan materiaPorPlan) throws Exception {
        return this.findById(materiaPorPlanService.save(materiaPorPlan));
    }

    public MateriaPorPlan update(MateriaPorPlan materiaPorPlan) throws Exception {
        return materiaPorPlanService.update(materiaPorPlan);
    }

    public boolean delete(MateriaPorPlan materiaPorPlan) throws Exception {
        MateriaPorPlan materiaPorPlanToDelete = materiaPorPlanService.findById(materiaPorPlan);
        return materiaPorPlanService.delete(materiaPorPlanToDelete);
    }
    
}
