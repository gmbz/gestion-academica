package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.PlanEstudio;
import com.utn.gestionacademica.repository.PlanEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanEstudioServiceImpl implements IPlanEstudioService {

    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    @Override
    public List<PlanEstudio> findAll() throws Exception {
        try {
            return planEstudioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PlanEstudio findById(PlanEstudio plan) throws Exception {
        try {
            Optional<PlanEstudio> entity = planEstudioRepository.findById(plan.getId());
            return entity.get();
        } catch (Exception e) {
            throw new Exception("No se encuentra el plan");
        }
    }

    @Override
    public PlanEstudio save(PlanEstudio plan) throws Exception {
        try {
            return planEstudioRepository.save(plan);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PlanEstudio update(PlanEstudio plan) throws Exception {
        try {
            return planEstudioRepository.save(plan);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(PlanEstudio plan) throws Exception {
        try {
            planEstudioRepository.deleteById(plan.getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
