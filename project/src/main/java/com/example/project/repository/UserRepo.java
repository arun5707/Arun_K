package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    User findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByUsernameAndRole(String username, String role);
}