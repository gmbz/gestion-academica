package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll() throws Exception;

    public Usuario findById(Usuario usuario) throws Exception;

    public Usuario save(Usuario usuario) throws Exception;

    public Usuario update(Usuario usuario) throws Exception;

    public boolean delete(Usuario usuario) throws Exception;


}
