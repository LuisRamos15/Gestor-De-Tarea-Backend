package com.example.GestorDeTareas.DTO;

import com.example.GestorDeTareas.Modelos.Tareas;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class TareasDTO {
    private Long id;

    private String titulo;

    private String descripcion;

    private String fechaVencimiento;



    private String prioridad;
    public enum Estado { COMPLETADO, PENDIENTE, EN_PROCESO };
    private Estado status;

    public Estado getStatus() {
        return status;
    }

    public void setStatus(Estado status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public TareasDTO() {
    }

    public TareasDTO(Long id, String titulo, String descripcion, String fechaVencimiento, String prioridad, Estado status) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.status = status;
    }

}
