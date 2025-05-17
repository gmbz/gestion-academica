package com.utn.gestionacademica.repository;

import com.utn.gestionacademica.model.PlanEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {

}
