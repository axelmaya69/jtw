package com.example.JsonWebToken.configs;


import com.example.JsonWebToken.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//agregando notacion @Conigutation
@Configuration
public class ApplicationConfiguration {

    //implementando la interaz userrepository
    private final UserRepository userRepository;

    //inyectando sus dependencias
    public ApplicationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //configurando el bean para encontar por email
    //y lanzar una exceptcion si no se encuentra
    @Bean
    UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    //Creando el bean para password enconder
    //o para encriptar contraseña
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //implementando otro metodo de spring boot por defecto para
    //autenticar usuarios (con credenciales) y los deja pasar o no
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
