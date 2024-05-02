package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.CategoriaDTO;
import com.example.GestorDeTareas.DTO.TareasDTO;

import java.util.List;

public interface CategoriaServicio {

    public CategoriaDTO crearCategoria (long tareaId, CategoriaDTO categoriaDTO);

    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);

    void eliminarCategoria(Long id);

    public List<CategoriaDTO> obtenerCategoriasPorTareasId(long tareasId);


}
