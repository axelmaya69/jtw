package com.example.JsonWebToken.dtos;

import lombok.Getter;
import lombok.Setter;

//clase para ayudar a registrar un usuario
//implementando inyeccion de dependencias,
//aqui se pasa el email, la contraseña y un nombre completo
public class RegisterUserDto  {

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String fullName;
}
