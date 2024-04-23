package com.example.GestorDeTareas.Repositorio;

import com.example.GestorDeTareas.Modelos.EstadoDeTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoDeTareaRepositorio extends JpaRepository<EstadoDeTareas, Long> {
}
