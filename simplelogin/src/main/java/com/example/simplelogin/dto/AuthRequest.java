package com.example.simplelogin.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String email; // Optional for login, needed for register
}