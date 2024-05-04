package com.example.GestorDeTareas.Modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "tareas")
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 20, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    @Column(name = "prioridad")
    private String prioridad;

    @Column(name = "usuario_Id")
    private Long usuarioId;

    public enum Estado { COMPLETADO, PENDIENTE, EN_PROCESO };
    @Enumerated (EnumType.STRING)
    private Estado status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Tareas_Categorias", joinColumns = @JoinColumn(name = "Tareas_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Categorias_id", referencedColumnName = "id")
    )
    private Set<Categoria> categorias = new HashSet<>();


    public Tareas(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

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

    public Tareas(Long id, String titulo, String descripcion, String fechaVencimiento, String prioridad, Long usuarioId, Estado status, Set<Categoria> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.usuarioId = usuarioId;
        this.status = status;
        this.categorias = categorias;
    }

    public Tareas() {
    }
}
