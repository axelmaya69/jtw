package com.example.JsonWebToken.responses;

import lombok.Getter;
import lombok.Setter;

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
