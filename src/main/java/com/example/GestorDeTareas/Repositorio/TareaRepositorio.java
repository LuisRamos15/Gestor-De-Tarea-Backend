package com.example.GestorDeTareas.Repositorio;

import com.example.GestorDeTareas.Modelos.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepositorio extends JpaRepository<Tareas, Long> {
    List<Tareas> findByUsuarioId(Long usuarioId);

}
