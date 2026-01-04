package com.example.simplelogin.service;

import com.example.simplelogin.dto.AuthRequest;
import com.example.simplelogin.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.simplelogin.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(AuthRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // In real apps, hash this password!
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    public User loginUser(AuthRequest request) {
        Optional<User> user = userRepository.findByUsername(request.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(request.getPassword())) {
            return user.get();
        }
        return null;
    }
}