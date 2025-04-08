package com.example.JsonWebToken.dtos;

import lombok.Getter;
import lombok.Setter;

//Clase para manejar usando inyeccion de dependencias
//donde se pasa un email y password

public class LoginUserDto {
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;
}
