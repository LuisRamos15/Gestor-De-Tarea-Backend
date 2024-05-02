package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;


import java.util.List;

public interface TareaServicio {

    public TareasDTO crearTarea(long categoriaId, TareasDTO tareaDto);

    public List<TareasDTO> obtenerTodasLasTareas();

    TareasDTO obtenerTareaPorId(Long id);

    TareasDTO ActualizarTarea(TareasDTO tareaDto, long id);

    void eliminarTarea(Long id);
}
