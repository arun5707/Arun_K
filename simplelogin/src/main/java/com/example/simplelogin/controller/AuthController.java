package com.example.simplelogin.controller;

import com.example.simplelogin.dto.AuthRequest;
import com.example.simplelogin.model.User;
import com.example.simplelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        try {
            userService.registerUser(request);
            return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully!"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        User user = userService.loginUser(request);
        if (user != null) {
            return ResponseEntity.ok(Collections.singletonMap("message", "Login successful!"));
        } else {
            return ResponseEntity.status(401).body(Collections.singletonMap("message", "Invalid username or password"));
        }
    }
}