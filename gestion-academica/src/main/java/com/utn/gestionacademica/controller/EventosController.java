package com.utn.gestionacademica.controller;

import com.utn.gestionacademica.model.Evento;
import com.utn.gestionacademica.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventosController {

    private final IEventoService eventoService;
    
    @Autowired
    public EventosController(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    public List<Evento> findAll() throws Exception {
        List<Evento> eventos = eventoService.findAll();
        for (Evento evento : eventos) {
            evento.setDiasFaltantes(getDaysUntil(evento.getFecha()));
        }
        return eventos;
    }

    public Evento findById(Evento evento) throws Exception {
        Evento foundEvento = eventoService.findById(evento);
        foundEvento.setDiasFaltantes(getDaysUntil(evento.getFecha()));
        return foundEvento;
    }

    public Evento save(Evento evento) throws Exception {
        return this.findById(eventoService.save(evento));
    }

    public Evento update(Evento evento) throws Exception {
        return eventoService.update(evento);
    }

    public boolean delete(Evento evento) throws Exception {
        Evento eventoToDelete = eventoService.findById(evento);
        return eventoService.delete(eventoToDelete);
    }

    public List<Evento> saveMany(List<Evento> materias) throws Exception {
        List<Evento> savedEventos = new ArrayList<>();
        for (Evento evento : materias) {
            savedEventos.add(eventoService.save(evento));
        }
        return savedEventos;
    }

    private static long getDaysUntil(LocalDate targetDate) {
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(today, targetDate);
    }
    
}

