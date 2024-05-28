package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Modelos.Tareas;


import java.util.List;

public interface TareaServicio {

    public TareasDTO crearTarea(TareasDTO tareaDto, Long usuarioId);

    public List<TareasDTO> obtenerTodasLasTareas();

    Object obtenerTareaPorId(Long usuarioId);

    TareasDTO ActualizarTarea(TareasDTO tareaDto, long id);

    void eliminarTarea(Long id);
}
