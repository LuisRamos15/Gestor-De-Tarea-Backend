package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Excepciones.ResourceNotFoundException;
import com.example.GestorDeTareas.Modelos.Categoria;
import com.example.GestorDeTareas.Modelos.Tareas;
import com.example.GestorDeTareas.Repositorio.CategoriaRepositorio;
import com.example.GestorDeTareas.Repositorio.TareaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TareaServicioImpl implements TareaServicio{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;


    @Override
    public TareasDTO crearTarea(long categoriaId, TareasDTO tareaDto) {
        Tareas tareas = mapearEntidad(tareaDto);
        Categoria categoria = categoriaRepositorio.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria", "id", categoriaId));
        Set<Categoria> categorias = new HashSet<>();
        categorias.add(categoria);
        tareas.setCategorias(categorias);
        Tareas nuevaTarea = tareaRepositorio.save(tareas);
        return mapearDTO(nuevaTarea);
    }

    @Override
    public List<TareasDTO> obtenerTodasLasTareas() {
        List<Tareas> listaDeTareas = tareaRepositorio.findAll();
        return listaDeTareas.stream().map(tareas -> mapearDTO(tareas)).collect(Collectors.toList());
    }

    @Override
    public TareasDTO obtenerTareaPorId(Long id) {
        Tareas tareas =tareaRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tareas", "id", id));
        return mapearDTO(tareas);
    }

    @Override
    public TareasDTO ActualizarTarea(TareasDTO tareaDto, long id) {
        Tareas tareas = tareaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tareas", "id", id));

        tareas.setTitulo(tareaDto.getTitulo());
        tareas.setDescripcion(tareaDto.getDescripcion());
        tareas.setFechaVencimiento(tareaDto.getFechaVencimiento());
        tareas.setPrioridad(tareaDto.getPrioridad());

        Tareas tareaActualizada = tareaRepositorio.save(tareas);
        return mapearDTO(tareaActualizada);
    }

    @Override
    public void eliminarTarea(Long id) {
        Tareas tareas = tareaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", id));
        tareaRepositorio.delete(tareas);

    }


    private TareasDTO mapearDTO(Tareas tareas) {
        TareasDTO tareasDTO = modelMapper.map(tareas, TareasDTO.class);
        return tareasDTO;
    }

    private Tareas mapearEntidad(TareasDTO tareasDTO) {
        Tareas tareas = modelMapper.map(tareasDTO, Tareas.class);
        return tareas;
    }
}
