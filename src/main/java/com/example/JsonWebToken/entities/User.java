package com.example.JsonWebToken.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String fullName;

    @Column(unique = true, length = 100, nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    @Getter
    @Setter
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Getter
    @Setter
    private Date updatedAt;
    
}
