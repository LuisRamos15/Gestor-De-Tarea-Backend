package com.example.GestorDeTareas.Controlador;

import com.example.GestorDeTareas.DTO.EstadoDeTareaDTO;
import com.example.GestorDeTareas.Servicio.EstadoDeTareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/EstadoDeTarea")
public class EstadoDeTareaControlador {

    @Autowired
    private EstadoDeTareaServicio estadoDeTareaServicio;

    @PostMapping
    public ResponseEntity<EstadoDeTareaDTO> guardarEstadoDeTarea(@RequestBody EstadoDeTareaDTO estadoDeTareaDTO){
        return new ResponseEntity<>(estadoDeTareaServicio.crearEstadoDeTarea(estadoDeTareaDTO), HttpStatus.CREATED);
    }


}
