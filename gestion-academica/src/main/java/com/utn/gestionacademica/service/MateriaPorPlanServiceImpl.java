package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.MateriaPorPlan;
import com.utn.gestionacademica.repository.MateriaPorPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaPorPlanServiceImpl implements IMateriaPorPlanService {

    @Autowired
    private MateriaPorPlanRepository materiaPorPlanRepository;

    @Override
    public List<MateriaPorPlan> findAll() throws Exception {
        try {
            return materiaPorPlanRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron materias", e);
        }
    }

    @Override
    public MateriaPorPlan findById(MateriaPorPlan materiaPorPlan) throws Exception {
        return materiaPorPlanRepository.findById(materiaPorPlan.getId()).orElseThrow(() -> new Exception("No se encuentra la materiaPorPlanRepository"));
    }

    @Override
    public MateriaPorPlan save(MateriaPorPlan materiaPorPlan) throws Exception {
        try {
            return materiaPorPlanRepository.save(materiaPorPlan);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MateriaPorPlan update(MateriaPorPlan materiaPorPlan) throws Exception {
        try {
            return materiaPorPlanRepository.save(materiaPorPlan);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(MateriaPorPlan materiaPorPlan) throws Exception {
        try {
            materiaPorPlanRepository.deleteById(materiaPorPlan.getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
