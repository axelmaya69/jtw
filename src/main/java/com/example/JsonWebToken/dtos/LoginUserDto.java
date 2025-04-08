package com.example.JsonWebToken.dtos;

import lombok.Getter;
import lombok.Setter;


public class LoginUserDto {
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;
}
