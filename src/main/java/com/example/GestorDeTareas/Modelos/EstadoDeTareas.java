package com.example.GestorDeTareas.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadoDeTarea")
public class EstadoDeTareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EstadoDeTarea")
    private String NombreDelEstado;

    public EstadoDeTareas() {
    }

    public EstadoDeTareas(Long id, String nombreDelEstado) {
        this.id = id;
        NombreDelEstado = nombreDelEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDelEstado() {
        return NombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        this.NombreDelEstado = nombreDelEstado;
    }
}
