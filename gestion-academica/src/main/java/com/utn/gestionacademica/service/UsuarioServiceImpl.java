package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Usuario;
import com.utn.gestionacademica.model.Usuario;
import com.utn.gestionacademica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements  IUsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron usuarios", e);
        }
    }

    @Override
    public Usuario findById(Usuario usuario) throws Exception {
        return usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new Exception("No se encuentra la usuario"));
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Usuario update(Usuario usuario) throws Exception {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Usuario usuario) throws Exception {
        try {
            usuarioRepository.deleteById(usuario.getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
