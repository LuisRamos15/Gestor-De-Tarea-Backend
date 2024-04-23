package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;


import java.util.List;

public interface TareaServicio {

    TareasDTO crearTarea(TareasDTO tareaDto);
    List<TareasDTO> obtenerTodasLasTareas();

    TareasDTO obtenerTareaPorId(Long id);

    TareasDTO ActualizarTarea(TareasDTO tareaDto, long id);

    void eliminarTarea(Long id);
}
