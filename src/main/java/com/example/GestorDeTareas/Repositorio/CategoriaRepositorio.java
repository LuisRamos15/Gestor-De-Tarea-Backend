package com.example.GestorDeTareas.Repositorio;

import com.example.GestorDeTareas.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
