package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.MateriaPorPlan;

import java.util.List;

public interface IMateriaPorPlanService {

    public List<MateriaPorPlan> findAll() throws Exception;

    public MateriaPorPlan findById(MateriaPorPlan materiaPorPlan) throws Exception;

    public MateriaPorPlan save(MateriaPorPlan materiaPorPlan) throws Exception;

    public MateriaPorPlan update(MateriaPorPlan materiaPorPlan) throws Exception;

    public boolean delete(MateriaPorPlan materiaPorPlan) throws Exception;


}
