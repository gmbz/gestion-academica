package com.utn.gestionacademica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plan_estudio")
public class PlanEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public PlanEstudio() {
    }

    public PlanEstudio(Long idPlan) {
    }

    public PlanEstudio(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
