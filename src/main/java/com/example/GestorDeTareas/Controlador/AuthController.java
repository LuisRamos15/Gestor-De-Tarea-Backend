package com.example.GestorDeTareas.Controlador;

import com.example.GestorDeTareas.DTO.UsuarioDTO;
import com.example.GestorDeTareas.Modelos.Usuario;
import com.example.GestorDeTareas.Servicio.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Usuario register(@RequestBody UsuarioDTO usuarioDTO) {
        return userService.register(usuarioDTO);
    }

    @PostMapping("/login")
    public Object login(@RequestBody UsuarioDTO usuarioDTO) {
        return userService.login(usuarioDTO);
    }

    @GetMapping("/verify")
    public Claims verifyToken(@RequestParam String token) {
        return userService.verifyToken(token);
    }
}