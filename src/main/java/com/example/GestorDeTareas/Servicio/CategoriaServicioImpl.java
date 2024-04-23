package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.CategoriaDTO;
import com.example.GestorDeTareas.Modelos.Categoria;
import com.example.GestorDeTareas.Repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.GestorDeTareas.Excepciones.ResourceNotFoundException;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {

        Categoria categoriaRecibida = mapearEntidad(categoriaDTO);
        Categoria nuevaCategoria = categoriaRepositorio.save(categoriaRecibida);
        CategoriaDTO categoriaRespuesta = mapearDTO(nuevaCategoria);

        return categoriaRespuesta;

    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria =categoriaRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria", " Id", id));

        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescripcion(categoriaDTO.getDescripcion());

        Categoria categoriaActualizada = categoriaRepositorio.save(categoria);

        return mapearDTO(categoriaActualizada);
    }

    @Override
    public void eliminarCategoria(Long id) {
        Categoria categoria =categoriaRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria", " Id", id));

        categoriaRepositorio.delete(categoria);
    }


    private CategoriaDTO mapearDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaDTO;
    }

    private Categoria mapearEntidad(CategoriaDTO categoriaDTO) {
         Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return categoria;
    }
}
