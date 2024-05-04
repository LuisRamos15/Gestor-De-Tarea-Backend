package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;


import java.util.List;

public interface TareaServicio {

    public TareasDTO crearTarea(long categoriaId, TareasDTO tareaDto, Long usuarioId);

    public List<TareasDTO> obtenerTodasLasTareas();

    Object obtenerTareaPorId(Long usuarioId);

    TareasDTO ActualizarTarea(TareasDTO tareaDto, long id);

    void eliminarTarea(Long id);
}
