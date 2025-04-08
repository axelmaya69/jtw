package com.example.JsonWebToken.repositories;



import com.example.JsonWebToken.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//INterfaz para obtener todos los metodos para hacer un crud
//dentro de la clase usuario, añadiendo uno personalizado que es
//el de encontrar un email.
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}