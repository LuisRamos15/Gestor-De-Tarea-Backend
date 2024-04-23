package com.example.GestorDeTareas.DTO;

import com.example.GestorDeTareas.Modelos.Usuario;

public class AuthDTO {
    private Usuario user;
    private String token;
    private String error;

    public AuthDTO() {
    }

    public AuthDTO(Usuario user, String token, String error) {
        this.user = user;
        this.token = token;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
