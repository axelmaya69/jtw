package com.example.JsonWebToken.dtos;

import lombok.Getter;
import lombok.Setter;

public class RegisterUserDto  {

    @Getter
    @Setter
    private String email;

    private String password;

    private String fullName;
}
