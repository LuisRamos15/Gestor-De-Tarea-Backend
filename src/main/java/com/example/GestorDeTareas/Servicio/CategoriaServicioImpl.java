package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.CategoriaDTO;
import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Modelos.Categoria;
import com.example.GestorDeTareas.Modelos.Tareas;
import com.example.GestorDeTareas.Repositorio.CategoriaRepositorio;
import com.example.GestorDeTareas.Repositorio.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.GestorDeTareas.Excepciones.ResourceNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private TareaRepositorio tareaRepositorio;


    @Override
    public CategoriaDTO crearCategoria(long tareaId, CategoriaDTO categoriaDTO) {
        Categoria categoria = mapearEntidad(categoriaDTO);
        Tareas tarea = tareaRepositorio.findById(tareaId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
        Set<Tareas> tareas = new HashSet<>();
        tareas.add(tarea);
        categoria.setTareas(tareas);
        Categoria nuevaCategoria = categoriaRepositorio.save(categoria);
        return mapearDTO(nuevaCategoria);
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

    @Override
    public List<CategoriaDTO> obtenerCategoriasPorTareasId(long tareasId) {
        List<Categoria> categorias = categoriaRepositorio.findByTareasId(tareasId);
        return categorias.stream().map(this::mapearDTO).collect(Collectors.toList());
    }
    /*@Override
    public List<CategoriaDTO> obtenerCategoriasPorTareasId(long tareasId) {
        List<Categoria> categorias = categoriaRepositorio.findByTareaId(tareasId);
        return categorias.stream().map(categoria -> mapearDTO(categoria)).collect(Collectors.toList());
    }*/

    private CategoriaDTO mapearDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);
        return categoriaDTO;
    }

    private Categoria mapearEntidad(CategoriaDTO categoriaDTO) {
         Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        return categoria;
    }
}
