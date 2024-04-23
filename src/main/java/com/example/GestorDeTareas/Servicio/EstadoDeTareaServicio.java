package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.EstadoDeTareaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EstadoDeTareaServicio {
    EstadoDeTareaDTO crearEstadoDeTarea(EstadoDeTareaDTO estadoDeTareaDTO);

    List<EstadoDeTareaDTO> obtenerTodosLosEstadosDeTarea();

    EstadoDeTareaDTO obtenerEstadoDeTareaPorId(Long id);

    EstadoDeTareaDTO actualizarEstadoDeTarea(EstadoDeTareaDTO estadoDeTareaDTO, long id);

    void eliminarEstadoDeTarea(Long id);
}
