package com.example.project.service;

import java.util.List;

import com.example.project.model.User;

public interface UserService {
    User addUser(User user);
    User loginUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getUsersByRole(String role);
    List<User> getUsersByUsernameAndRole(String username, String role);
}