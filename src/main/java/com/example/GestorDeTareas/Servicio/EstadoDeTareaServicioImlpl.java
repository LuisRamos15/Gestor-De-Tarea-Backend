package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.EstadoDeTareaDTO;
import com.example.GestorDeTareas.Excepciones.ResourceNotFoundException;
import com.example.GestorDeTareas.Modelos.EstadoDeTareas;
import com.example.GestorDeTareas.Repositorio.EstadoDeTareaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EstadoDeTareaServicioImlpl implements EstadoDeTareaServicio{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EstadoDeTareaRepositorio estadoDeTareaRepositorio;

    @Override
    public EstadoDeTareaDTO crearEstadoDeTarea(EstadoDeTareaDTO estadoDeTareaDTO) {
        EstadoDeTareas estadoDeTareas = mapearEntidad((estadoDeTareaDTO));
        EstadoDeTareas nuevoEstadoDeTarea = estadoDeTareaRepositorio.save(estadoDeTareas);
        EstadoDeTareaDTO estadoDeTareaRespuesta = mapearDTO((nuevoEstadoDeTarea));
        return estadoDeTareaRespuesta;


    }

    @Override
    public List<EstadoDeTareaDTO> obtenerTodosLosEstadosDeTarea() {
        List<EstadoDeTareas> listaDeEstadoDeTarea = estadoDeTareaRepositorio.findAll();
        return listaDeEstadoDeTarea.stream().map(estadoDeTareas -> mapearDTO(estadoDeTareas)).collect(Collectors.toList());
    }

    @Override
    public EstadoDeTareaDTO obtenerEstadoDeTareaPorId(Long id) {
        EstadoDeTareas estadoDeTareas = estadoDeTareaRepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("EstadoDeTareas", "id", id));
        return mapearDTO(estadoDeTareas);
    }

    @Override
    public EstadoDeTareaDTO actualizarEstadoDeTarea(EstadoDeTareaDTO estadoDeTareaDTO, long id) {
        EstadoDeTareas estadoDeTareas = estadoDeTareaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("EstadoDeTareas", "id", id));
        estadoDeTareas.setNombreDelEstado(estadoDeTareaDTO.getNombreDelEstado());
        EstadoDeTareas estadoDeTareaActualizada = estadoDeTareaRepositorio.save(estadoDeTareas);

        return mapearDTO(estadoDeTareaActualizada);

    }

    @Override
    public void eliminarEstadoDeTarea(Long id) {
        EstadoDeTareas estadoDeTareas = estadoDeTareaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("EstadoDeTareas", "id", id));
        estadoDeTareaRepositorio.delete(estadoDeTareas);

    }
    private EstadoDeTareaDTO mapearDTO(EstadoDeTareas estadoDeTareas) {
        EstadoDeTareaDTO estadoDeTareaDTO = modelMapper.map(estadoDeTareas, EstadoDeTareaDTO.class);
        return estadoDeTareaDTO;
    }

    private EstadoDeTareas mapearEntidad(EstadoDeTareaDTO estadoDeTareaDTO) {
        EstadoDeTareas estadoDeTareas = modelMapper.map(estadoDeTareaDTO, EstadoDeTareas.class);
        return estadoDeTareas;
    }

}
