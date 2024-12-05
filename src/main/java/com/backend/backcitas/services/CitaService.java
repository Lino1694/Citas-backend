package com.backend.backcitas.services;

import com.backend.backcitas.ResourceNotFoundException;
import com.backend.backcitas.entities.Cita;
import com.backend.backcitas.entities.Usuario;
import com.backend.backcitas.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    public Cita crearCita(Cita cita) {
        cita.setFechaRegistro(LocalDate.now());
        cita.setEstado("PENDIENTE");
        return citaRepository.save(cita);
    }

    public Cita asignarCita(Long citaId, Usuario agente) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));
        cita.setFechaAsignacion(LocalDate.now()); cita.setAgenteAsignado(agente);
        cita.setEstado("ASIGNADA"); return citaRepository.save(cita);
    }

    public Cita completarCita(Long citaId) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));
        cita.setEstado("COMPLETADA"); cita.setFechaCerrado(LocalDate.now());
        return citaRepository.save(cita);
    }

    public Cita reabrirCita(Long citaId) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new ResourceNotFoundException("Cita no encontrada"));
        cita.setEstado("REABIERTA");
        return citaRepository.save(cita);
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public void eliminarCitas(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita no encontrado"));
        citaRepository.delete(cita);
    }
}