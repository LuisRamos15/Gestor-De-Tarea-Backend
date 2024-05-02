package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.CategoriaDTO;
import com.example.GestorDeTareas.DTO.TareasDTO;

import java.util.List;

public interface CategoriaServicio {

    CategoriaDTO crearCategoria (CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);
    void eliminarCategoria(Long id);
    List<CategoriaDTO> obtenerTodasLasCategorias();


}
