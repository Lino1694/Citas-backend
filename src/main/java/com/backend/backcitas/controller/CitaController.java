package com.backend.backcitas.controller;

import com.backend.backcitas.entities.Cita;
import com.backend.backcitas.entities.Usuario;
import com.backend.backcitas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.crearCita(cita));
    }

    @PostMapping("/asignar/{id}")
    public ResponseEntity<Cita> asignarCita(@PathVariable Long id, @RequestBody Usuario agente) {
        return ResponseEntity.ok(citaService.asignarCita(id, agente));
    }

    @PostMapping("/completar/{id}")
    public ResponseEntity<Cita> completarCita(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.completarCita(id));
    }

    @PostMapping("/reabrir/{id}")
    public ResponseEntity<Cita> reabrirCita(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.reabrirCita(id));
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listarcitas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCitas(@PathVariable Long id) {
        citaService.eliminarCitas(id);
        return ResponseEntity.noContent().build();
    }
}
