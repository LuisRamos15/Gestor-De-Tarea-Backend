package com.example.GestorDeTareas.Repositorio;

import com.example.GestorDeTareas.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    List<Categoria> findByTareasId(long tareaId);
}
