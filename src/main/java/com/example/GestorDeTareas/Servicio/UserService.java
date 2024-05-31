package com.example.GestorDeTareas.Servicio;

import com.example.GestorDeTareas.DTO.AuthDTO;
import com.example.GestorDeTareas.DTO.TareasDTO;
import com.example.GestorDeTareas.DTO.UsuarioDTO;
import com.example.GestorDeTareas.Modelos.Tareas;
import com.example.GestorDeTareas.Modelos.Usuario;
import com.example.GestorDeTareas.Repositorio.UsuarioRepositorio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    private static final Map<String, String> users = new HashMap<>();
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 900_000; // 15 minutes
    private static final String ISSUER = "your_issuer";

    public Usuario register(UsuarioDTO usuarioDTO) {

        Usuario usuario1 = mapearEntidad(usuarioDTO);

        Usuario nuevoUsuario = usuarioRepositorio.save(usuario1);

        return nuevoUsuario;

    }

    public Object login(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepositorio.findByEmail(usuarioDTO.getEmail());

        if (usuario.getEmail() == null ) {
            return "Error internal server";
        }
        String tokenUser = generateToken(usuario);
        return new Object[]{
                tokenUser,
                usuario.getId()
        };

        //relacionar la tarea con el usuario que se ha logeado
        //verificar que el usuario tenga el token para poder crear la tarea

    }

    private String generateToken(Usuario usuario) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(usuario.getUsername())
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public Claims verifyToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    private UsuarioDTO mapearDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    private Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        return usuario;
    }
}
