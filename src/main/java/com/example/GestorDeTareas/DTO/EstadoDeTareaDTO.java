package com.example.GestorDeTareas.DTO;

public class EstadoDeTareaDTO {
    private long id;
    private String NombreDelEstado;

    public EstadoDeTareaDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreDelEstado() {
        return NombreDelEstado;
    }

    public void setNombreDelEstado(String nombreDelEstado) {
        NombreDelEstado = nombreDelEstado;
    }

    public EstadoDeTareaDTO(long id, String nombreDelEstado) {
        this.id = id;
        this.NombreDelEstado = nombreDelEstado;
    }
}
