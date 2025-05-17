package com.utn.gestionacademica.repository;

import com.utn.gestionacademica.model.MateriaPorPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaPorPlanRepository extends JpaRepository<MateriaPorPlan, Long> {
}
