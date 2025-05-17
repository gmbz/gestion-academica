package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Evento;

import java.util.List;

public interface IEventoService {
    public List<Evento> findAll() throws Exception;

    public Evento findById(Evento evento) throws Exception;

    public Evento save(Evento evento) throws Exception;

    public Evento update(Evento evento) throws Exception;

    public boolean delete(Evento evento) throws Exception;

}
