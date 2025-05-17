package com.utn.gestionacademica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materia_por_plan")
public class MateriaPorPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Materia materia;

    @ManyToOne
    private PlanEstudio planEstudio;

    private String nombreEnPlan;

    private int numeroEnPlan;

    private boolean electiva;

    @OneToMany(mappedBy = "materiaPorPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioMateria> usuariosMateria = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "correlativas",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "correlativa_id")
    )
    private List<MateriaPorPlan> correlativas = new ArrayList<>();

    public MateriaPorPlan() {
    }

    public MateriaPorPlan(Long id) {
        this.id = id;
    }

    public MateriaPorPlan(List<MateriaPorPlan> correlativas, boolean electiva, int numeroEnPlan, String nombreEnPlan, PlanEstudio planEstudio, Materia materia, Long id) {
        this.correlativas = correlativas;
        this.electiva = electiva;
        this.numeroEnPlan = numeroEnPlan;
        this.nombreEnPlan = nombreEnPlan;
        this.planEstudio = planEstudio;
        this.materia = materia;
        this.id = id;
    }

    public List<MateriaPorPlan> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<MateriaPorPlan> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean isElectiva() {
        return electiva;
    }

    public void setElectiva(boolean electiva) {
        this.electiva = electiva;
    }

    public String getNombreEnPlan() {
        return nombreEnPlan;
    }

    public void setNombreEnPlan(String nombreEnPlan) {
        this.nombreEnPlan = nombreEnPlan;
    }

    public PlanEstudio getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(PlanEstudio planEstudio) {
        this.planEstudio = planEstudio;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroEnPlan() {
        return numeroEnPlan;
    }

    public void setNumeroEnPlan(int numeroEnPlan) {
        this.numeroEnPlan = numeroEnPlan;
    }

    @JsonIgnore
    public List<UsuarioMateria> getUsuarios() {
        return usuariosMateria;
    }

    public void setUsuarios(List<UsuarioMateria> usuariosMateria) {
        this.usuariosMateria = usuariosMateria;
    }
}
