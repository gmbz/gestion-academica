package com.utn.gestionacademica.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioMateriaId implements Serializable {

    private Long usuarioId;
    private Long materiaId;

    public UsuarioMateriaId() {
    }

    public UsuarioMateriaId(Long usuarioId, Long materiaId) {
        this.usuarioId = usuarioId;
        this.materiaId = materiaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioMateriaId)) return false;
        UsuarioMateriaId that = (UsuarioMateriaId) o;
        return Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(materiaId, that.materiaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, materiaId);
    }
}
