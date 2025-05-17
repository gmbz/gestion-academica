package com.utn.gestionacademica.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String descripcion;

    private Long diasFaltantes;

    @ManyToOne
    private MateriaPorPlan materiaPorPlan;

    public Evento() {
    }

    public Evento(Long id, LocalDate fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Evento(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MateriaPorPlan getMateriaPorPlan() {
        return materiaPorPlan;
    }

    public void setMateriaPorPlan(MateriaPorPlan materiaPorPlan) {
        this.materiaPorPlan = materiaPorPlan;
    }

    public Long getDiasFaltantes() {
        return diasFaltantes;
    }

    public void setDiasFaltantes(Long diasFaltantes) {
        this.diasFaltantes = diasFaltantes;
    }
}
