package com.utn.gestionacademica.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class UsuarioMateria {

    @EmbeddedId
    private UsuarioMateriaId id = new UsuarioMateriaId();

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @MapsId("materiaId")
    @JoinColumn(name = "materia_id")
    private MateriaPorPlan materiaPorPlan;

    @Enumerated(EnumType.STRING)
    private EstadoMateria estado;

    private LocalDate fecha;

    public UsuarioMateria() {
    }

    public UsuarioMateria(UsuarioMateriaId id) {
        this.id = id;
    }

    public UsuarioMateria(UsuarioMateriaId id, LocalDate fecha, EstadoMateria estado, MateriaPorPlan materiaPorPlan, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.materiaPorPlan = materiaPorPlan;
        this.usuario = usuario;
    }

    public UsuarioMateriaId getId() {
        return id;
    }

    public void setId(UsuarioMateriaId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MateriaPorPlan getMateria() {
        return materiaPorPlan;
    }

    public void setMateria(MateriaPorPlan materiaPorPlan) {
        this.materiaPorPlan = materiaPorPlan;
    }

    public EstadoMateria getEstado() {
        return estado;
    }

    public void setEstado(EstadoMateria estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
