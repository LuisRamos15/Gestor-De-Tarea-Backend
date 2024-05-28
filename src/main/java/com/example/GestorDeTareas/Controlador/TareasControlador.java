package com.example.GestorDeTareas.Controlador;

import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Modelos.Tareas;
import com.example.GestorDeTareas.Servicio.TareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareasControlador {
    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping
    public List<TareasDTO> listarTareas(){
        return tareaServicio.obtenerTodasLasTareas();
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<TareasDTO> guardarTarea(@RequestBody TareasDTO tareasDTO, @PathVariable(value = "usuarioId") long usuarioId) {
        return new ResponseEntity<>(tareaServicio.crearTarea(tareasDTO, usuarioId), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Object> obtenerTareaPorId(@PathVariable(value = "usuarioId") long usuarioId) {
        return ResponseEntity.ok(tareaServicio.obtenerTareaPorId(usuarioId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable(name = "id") long id) {
        tareaServicio.eliminarTarea(id);
        return new ResponseEntity<>("Tarea eliminada con exito", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareasDTO> actualizarTarea(@RequestBody TareasDTO tareasDTO, @PathVariable(name = "id") long id){
        TareasDTO tareaRespuesta = tareaServicio.ActualizarTarea(tareasDTO, id);
        return new ResponseEntity<>(tareaRespuesta, HttpStatus.OK);
    }

}
