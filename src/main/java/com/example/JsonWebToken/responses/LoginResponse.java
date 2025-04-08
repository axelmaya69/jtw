package com.example.JsonWebToken.responses;

import lombok.Getter;
import lombok.Setter;

//Clase para devolver lo del token mediante inyeccion de dependencias
//aqui se usa esta clase para indicar que se va a devolver un token
//y una fecha de expiracion en milisegundos.
public class LoginResponse {
    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private long expiresIn;


    public String getToken() {
        return token;
    }

}
