package com.example.GestorDeTareas.Modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tareas")
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




    @Column(name = "task_id")
    private String taskId;

    @Column(name = "titulo", length = 20, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "usuario_Id")
    private Long usuarioId;

    public enum Estado { COMPLETADO, PENDIENTE, EN_PROCESO }
    @Enumerated (EnumType.STRING)
    private Estado status;

    public Estado getStatus() {
        return status;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setStatus(Estado status) {
        this.status = status;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Tareas(Long id, String taskId, String titulo, String descripcion, String fechaVencimiento, String prioridad, String categoria, Long usuarioId, Estado status) {
        this.id = id;
        this.taskId = taskId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.usuarioId = usuarioId;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Tareas() {
    }
}
