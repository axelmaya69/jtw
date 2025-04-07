package com.example.JsonWebToken.controller;

import com.example.JsonWebToken.dtos.LoginUserDto;
import com.example.JsonWebToken.dtos.RegisterUserDto;
import com.example.JsonWebToken.entities.User;
import com.example.JsonWebToken.responses.LoginResponse;
import com.example.JsonWebToken.services.AuthenticationService;
import com.example.JsonWebToken.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Agregando notaciones para hacer la api con sus endpoints
//publicos y privados
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    //referencnando la clase jwtservice
    private final JwtService jwtService;

    //referencnando la clase authenticationService
    private final AuthenticationService authenticationService;

    //Inyectando sus dependencias
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    //Añadiendo la primera notacion para registrarse, pidiendo los datos mediante un
    //request body de la clase RegisterUserDto
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
     }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
