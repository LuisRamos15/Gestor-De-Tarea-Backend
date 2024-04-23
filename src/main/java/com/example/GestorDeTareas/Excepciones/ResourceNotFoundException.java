package com.example.GestorDeTareas.Excepciones;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String NombreDelRecurso;
    private String NombreDelCampo;
    private long ValorDelCampo;

    public ResourceNotFoundException( String NombreDelRecurso,  String NombreDelCampo, long ValorDelCampo) {
        super(String.format(" %s no encontrado con: %s '%s' ", NombreDelRecurso, NombreDelCampo, ValorDelCampo));
        this.NombreDelRecurso = NombreDelRecurso;
        this.NombreDelCampo = NombreDelCampo;
        this.ValorDelCampo = ValorDelCampo;
    }
}
