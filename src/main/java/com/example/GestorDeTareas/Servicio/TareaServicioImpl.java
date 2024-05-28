package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Excepciones.ResourceNotFoundException;
import com.example.GestorDeTareas.Modelos.Tareas;
import com.example.GestorDeTareas.Modelos.Usuario;
import com.example.GestorDeTareas.Repositorio.TareaRepositorio;
import com.example.GestorDeTareas.Repositorio.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaServicioImpl implements TareaServicio{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public TareasDTO crearTarea(TareasDTO tareaDto, Long usuarioId) {
        Tareas tareas = mapearEntidad(tareaDto);

        Optional<Usuario> usuario = usuarioRepositorio.findById(usuarioId);

        tareas.setUsuarioId(usuario.get().getId());

        Tareas nuevaTarea = tareaRepositorio.save(tareas);

        return mapearDTO(nuevaTarea);
    }

    @Override
    public List<TareasDTO> obtenerTodasLasTareas() {
        List<Tareas> listaDeTareas = tareaRepositorio.findAll();
        return listaDeTareas.stream().map(tareas -> mapearDTO(tareas)).collect(Collectors.toList());
    }

    @Override
    public Object obtenerTareaPorId(Long usuarioId) {
        try {
            Optional<Usuario> usuario = usuarioRepositorio.findById(usuarioId);

            List<Tareas> tareas = tareaRepositorio.findByUsuarioId(usuario.get().getId());



            return new Object[]{
                    tareas
            };
        } catch (Exception error) {
               return new Object[]{
                       error.getMessage()
               };
        }
    }

    @Override
    public TareasDTO ActualizarTarea(TareasDTO tareaDto, long id) {
        Tareas tareas = tareaRepositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tareas", "id", id));

        tareas.setTitulo(tareaDto.getTitulo());
        tareas.setDescripcion(tareaDto.getDescripcion());
        tareas.setFechaVencimiento(tareaDto.getFechaVencimiento());
        tareas.setPrioridad(tareaDto.getPrioridad());
        tareas.setCategoria(tareaDto.getCategoria());
        Tareas.Estado estado = Tareas.Estado.valueOf(tareaDto.getStatus().name());
        tareas.setStatus(estado);

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
