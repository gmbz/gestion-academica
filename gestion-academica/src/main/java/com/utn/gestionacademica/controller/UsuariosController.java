package com.utn.gestionacademica.controller;

import com.utn.gestionacademica.model.*;
import com.utn.gestionacademica.service.IUsuarioService;
import com.utn.gestionacademica.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuariosController {

    @Autowired
    private final IUsuarioService usuarioService;

    @Autowired
    public UsuariosController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    private MateriaPorPlanController materiaPorPlanController;

    public List<Usuario> findAll() throws Exception {
        return usuarioService.findAll();
    }

    public Usuario findById(Usuario usuario) throws Exception {
        return usuarioService.findById(usuario);
    }

    public Usuario save(Usuario usuario) throws Exception {
        initializeUserSubjects(usuario);
        return this.findById(usuarioService.save(usuario));
    }

    public Usuario update(Usuario usuario) throws Exception {
        return usuarioService.update(usuario);
    }

    public boolean delete(Usuario usuario) throws Exception {
        Usuario usuarioToDelete = usuarioService.findById(usuario);
        return usuarioService.delete(usuarioToDelete);
    }

    public List<Usuario> saveMany(List<Usuario> usuarios) throws Exception {
        List<Usuario> savedUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            savedUsuarios.add(usuarioService.save(usuario));
        }
        return savedUsuarios;
    }

    private void initializeUserSubjects(Usuario user) throws Exception {
        List<MateriaPorPlan> materias = materiaPorPlanController.findAll();
        List<UsuarioMateria> usuarioMaterias = materias.stream()
                .map((MateriaPorPlan materiaPlan) -> {
                    UsuarioMateria usuarioMateria = new UsuarioMateria();
                    usuarioMateria.setId(new UsuarioMateriaId(user.getId(), materiaPlan.getId()));
                    usuarioMateria.setUsuario(user);
                    usuarioMateria.setMateria(materiaPlan);
                    usuarioMateria.setEstado(EstadoMateria.NO_CURSADA);
                    return usuarioMateria;
                }).toList();
        user.setMaterias(usuarioMaterias);
    }
}
