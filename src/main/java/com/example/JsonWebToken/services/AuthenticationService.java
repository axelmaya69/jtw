package com.example.JsonWebToken.services;


import com.example.JsonWebToken.dtos.LoginUserDto;
import com.example.JsonWebToken.dtos.RegisterUserDto;
import com.example.JsonWebToken.entities.User;
import com.example.JsonWebToken.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Se añade la notacion Service para indicarle que es un servicio.
@Service
public class AuthenticationService {

    //se referencian las diferentes clases o intefaces.
    //que da spring boot o que fueron creadas
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    //se inyectan sus dependencias.
    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    //Se crea un metodo para registrar usuarios en el cual se obtienen
    //los datos de la clase RegisterUserDto agregandole un nombre, email
    //y password, para finalmente guardarlo.
    public User signup(RegisterUserDto input) {
        User user = new User();
                user.setFullName(input.getFullName());
                user.setEmail(input.getEmail());
                user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);

    }
    //Se crea un metodo para autenticar al usuario, en este metodo
    //se obtienen la contraseña y email del usuario y se autentica
    //para devolver si es valido o no
    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
