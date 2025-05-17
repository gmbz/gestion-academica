package com.utn.gestionacademica.service;

import com.utn.gestionacademica.model.Evento;
import com.utn.gestionacademica.model.Evento;
import com.utn.gestionacademica.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService{
    
    @Autowired
    private EventoRepository eventoRepository;
    
    @Override
    public List<Evento> findAll() throws Exception {
        try {
            return eventoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("No se encontraron eventos", e);
        }
    }

    @Override
    public Evento findById(Evento evento) throws Exception {
        return eventoRepository.findById(evento.getId()).orElseThrow(() -> new Exception("No se encuentra la evento"));
    }

    @Override
    public Evento save(Evento evento) throws Exception {
        try {
            return eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Evento update(Evento evento) throws Exception {
        try {
            return eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Evento evento) throws Exception {
        try {
            eventoRepository.deleteById(evento.getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
