package com.example.GestorDeTareas.Controlador;

import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.Servicio.TareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tareas")
public class TareasControlador {
    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping
    public List<TareasDTO> listarTareas(){
        return tareaServicio.obtenerTodasLasTareas();
    }

    @PostMapping
    public ResponseEntity<TareasDTO> guardarPublicacion(@RequestBody TareasDTO tareasDTO) {
        return new ResponseEntity<>(tareaServicio.crearTarea(tareasDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TareasDTO> obtenerPublicacionPorId(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(tareaServicio.obtenerTareaPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id) {
        tareaServicio.eliminarTarea(id);
        return new ResponseEntity<>("Tarea eliminada con exito", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TareasDTO> actualizarTarea(@RequestBody TareasDTO tareasDTO, @PathVariable(name = "id") long id){
        TareasDTO tareaRespuesta = tareaServicio.ActualizarTarea(tareasDTO, id);
        return new ResponseEntity<>(tareaRespuesta, HttpStatus.OK);
    }
}
