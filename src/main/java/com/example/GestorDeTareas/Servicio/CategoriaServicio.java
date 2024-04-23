package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.CategoriaDTO;

public interface CategoriaServicio {

    CategoriaDTO crearCategoria (CategoriaDTO categoriaDTO);
    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);
    void eliminarCategoria(Long id);


}
