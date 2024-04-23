package com.example.GestorDeTareas.Repositorio;

import com.example.GestorDeTareas.DTO.UsuarioDTO;
import com.example.GestorDeTareas.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
