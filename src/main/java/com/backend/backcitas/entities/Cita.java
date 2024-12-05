package com.backend.backcitas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaRegistro;
    private String proyecto;
    private String consulta;
    private LocalDate fechaAsignacion;
    @ManyToOne
    private Usuario agenteAsignado;
    private String estado; // PENDIENTE, ASIGNADA, COMPLETADA, REABIERTA
    private LocalDate fechaCerrado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Usuario getAgenteAsignado() {
        return agenteAsignado;
    }

    public void setAgenteAsignado(Usuario agenteAsignado) {
        this.agenteAsignado = agenteAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCerrado() {
        return fechaCerrado;
    }

    public void setFechaCerrado(LocalDate fechaCerrado) {
        this.fechaCerrado = fechaCerrado;
    }
}
