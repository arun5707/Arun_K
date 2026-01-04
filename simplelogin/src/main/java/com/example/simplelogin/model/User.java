package com.example.simplelogin.model;

import jakarta.persistence.*;
import lombok.Data; // Ensure lombok dependency is added, or write getters/setters manually

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;
}